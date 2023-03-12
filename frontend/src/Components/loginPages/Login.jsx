import React,{useState} from "react";

import "./ForgetPassword";
import {useNavigate } from "react-router-dom";
import BaseLayout from "../BaseLayout";
import Footer from '../home/Footer';
import http from '../../httpCommon'

import '../adminDashboard/AdminHome.jsx'
import '../userDashboard/UserHome'

const Login=()=>{
  const navigator= useNavigate();

  const [toDisable, setToDisable]=useState(false);


  const customerVerifyURL = '/customerLogin-verifyOtp'
  const generateCustomerOtpURL ='/customerLogin-generateOtp'
  const generateAdminOtpURL='/adminLogin-generateOtp'
  const adminVerifyURL='/adminLogin-verifyOtp'
  const customerLoginURL ="/customerLogin-login"
  const adminLoginURL ="/adminLogin-login"

  const  [mobileNumber, setUser]=useState({mobileNumber:''});
  const  [password, setPassword]=useState({password:''});
  const [otp, setOtp]=useState({otp:''});

  const [isAdmin, setIsAdmin]=useState();
  const [otpVerifed, setOtpVerified] = useState(false);

  const onUserChange=(e)=>{
    setUser({mobileNumber: e.target.value})
  }
  const onPassChange=(e)=>{
    setPassword({password: e.target.value})
  }
  const onOtpChange=(e)=>{
    setOtp({otp: e.target.value})
  }

  const getOTP=()=>{
    if(isAdmin){

    
    setToDisable(true);
    console.log(mobileNumber);
    http.post(generateAdminOtpURL, mobileNumber,{headers:{"Content-Type":"text/plain"}})
    .then(response=>{
      console.log('user exist: ' +response.data)
      if(response.data){
        window.alert("otp generated")
      }else window.alert("otp could not be generated");
    })
    .catch(error=>console.log(error))
  }else if(isAdmin===false){
    setToDisable(true);
    console.log(mobileNumber);
    http.post(generateCustomerOtpURL, mobileNumber,{headers:{"Content-Type":"text/plain"}})
    .then(response=>{
      console.log('user exist: ' +response.data)
      if(response.data){
        window.alert("otp generated")
      }else window.alert("otp could not be generated");
    })
    .catch(error=>console.log(error))
  }
  }
  const verifyOTP=()=>{
    if(isAdmin){
    http.post(adminVerifyURL, otp)
    .then(response=>{
      console.log(response.data)
      if(response.data){
        window.alert("otp Verified")
      }
      setOtpVerified(response.data)
    })
    .catch(error=>console.log(error))
  }else if(isAdmin===false){
    http.post(customerVerifyURL, otp)
    .then(response=>{
      console.log(response.data)
      if(response.data){
        window.alert("otp verified")
      }
      setOtpVerified(response.data)
    })
    .catch(error=>console.log(error))
  }
  }
const handleLogin=()=>{
  //admin
  if(otpVerifed){
  if(isAdmin){
    http.post(adminLoginURL, {mobileNo: mobileNumber.mobileNumber, password: password.password})
    .then(response=>{
      console.log(response.data)      
      if(response.data){
        navigator("/adminHome")
      }else{
        window.alert("login Falied")
      }
    })
    .catch(error=>{
      console.log(error)})

    }else if(isAdmin===false){
  //customer
    http.post(customerLoginURL, {mobileNo: mobileNumber.mobileNumber, password: password.password})
    .then(response=>{
      console.log(response.data)
      if(response.data){
        navigator("/userHome")
      }else{
        window.alert("login Falied")
      }
    })
    .catch(error=>{
      console.log(error)})
    }
  console.log(mobileNumber, password);
  setUser({mobileNumber:''})
  setPassword({password:''})
  setOtp({otp:''})
  setToDisable(false);
  }else window.alert("otp Not verified yet");
}
    
    return (<>
      <section>
  <div className="row"> 
  <BaseLayout/>
  </div>
  <div>
    <div className="mt-5">&nbsp;</div>
    <div className="mt-5">&nbsp;</div>
  <div className="row col-4 offset-4 mt-5 mb-5 bg-light p-4 border">
    <form className="row g-3">
    <h3 className="text-center">Please Sign in</h3>
    <fieldset id="toDisable" disabled={toDisable}>
  
  <div className="col-12 d-flex flex-row">
  <img className="mt-2 me-2" src="https://cdn-icons-png.flaticon.com/512/456/456212.png" style={{height: "20px", width: "20px"}}/>
  <input type="text" className="form-control mb-3" name="userNumber" onChange={onUserChange} value={mobileNumber.mobileNumber}/>
  </div>
  <div className="col-12 d-flex flex-row">
  <img className="mt-2 me-2" src="https://cdn-icons-png.flaticon.com/512/3064/3064155.png" style={{height: "20px", width: "20px"}}/>
    <input type="password" className="form-control" name="password" onChange={onPassChange} value={password.password}/>
</div>

<div className="text-end mt-2 mb-1">
<a href="forgetpassword" className="btn" style={{color:"blue"}}><h6>Forget password/Reset Password</h6></a>
</div>

  <div className="row text-center">

    <div className="form-check col d-flex flex-row">
      <input className="form-check-input radios" type="radio" name="role" id="flexRadioDefault1" onChange={()=>{setIsAdmin(true)}} />
      <div className="flex-row radiolabels">Admin</div>
    </div>

    <div className="form-check col d-flex flex-row">
      <input className="form-check-input radios" type="radio" name="role" id="flexRadioDefault2" onChange={()=>{setIsAdmin(false)}} required />
      <div className="flex-row radiolabels">User</div>
    </div>

  </div>
  </fieldset>
<div className="row mt-3 mb-2 ms-3" >
  <button type="button" className="btn btn-warning col-form flex-row col-4" onClick={getOTP}>Get OTP</button>
  <div className="col">
    <input type="text" className="form-control col-form-control col-8 flex-row" placeholder="Enter OTP" onChange={onOtpChange} value={otp.otp}/>
    <button type="button" className="btn btn-warning col-form flex-row col-4" onClick={verifyOTP}>Verify OTP</button>
  </div>
</div>

<div className="col-12 mt-3 text-center">
  <button type="button" className="btn btn-danger flex-row" onClick={handleLogin}>Login</button>
  </div>  
    </form>
    </div>
</div>
    <div className="row">
    <Footer/>
    </div>
</section>
</>
)

}

export default Login;