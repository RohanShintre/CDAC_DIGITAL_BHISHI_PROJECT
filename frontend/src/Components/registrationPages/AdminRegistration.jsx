import React, {useEffect, useState} from "react";
import "../registrationPages/GeneratePassword";
import { Navigate, useNavigate } from "react-router-dom";
import http from '../../httpCommon';
import BaseLayout from "../BaseLayout";
import Footer from '../home/Footer';
import {ValidatePasswordFields,ValidatePanNumberFields,ValidationResult, ValidateTextFields , ValidateAadharNumberFields, ValidatePhoneNumberFields, ValidateZipCodeFields} from '../Validations';

const AdminRegistration=()=>{
  const getOtpURL="/adminRegistration-generateOtp/";
  const verifyOtpURL="/adminRegistration-verifyOtp";
  const adminRegistrationURL="/adminRegistration-register";

  const navigator=useNavigate();
  
  
  function handleNav(){
    navigator("/generatePassword")
  }


  const [otp, setOTP]= useState({
    otp:""
  });


  const [checkCustomerNumberExists , setCheckCustomerNumberExists] = useState({
    number:""
  });


  var [dataToRegister, setDataToRegister] = useState({
    firstName:"",
    middleName:"",
    lastName:"",
    mobileNumber:"",
    password:"",
    alternateNumber:"",
    aadharNumber:"",
    panNumber:"",
    street:"",
    locality:"",
    cityOrVillage:"",
    tahsil:"",
    district:"",
    state:"",
    zipCode:""
  });


  const onChange = (e)=> {
    setDataToRegister({...dataToRegister, [e.target.name]: e.target.value});
  }

  const handleOTP=(e)=>{
    setOTP({otp:e.target.value})
  }

  
  const [toDisable,setToDisable]=useState(false);// entry field
  
  
  const [postPermission, setPostPermission]=useState(false);// permission for otp and data posting


  const [otpVerified, setOtpVerified]=useState(false);//tochange to false default


  
  const [validationStatus, setValidationStatus] = useState({
    firstName:0,
    middleName:0,
    lastName:0,
    mobileNumber:0,
    password:0,
    alternateNumber:0,
    aadharNumber:0,
    panNumber:0,
    zipCode:0,
    customerAadharPic:0,
  });
  const [confirmPassword, setConfirmPassword]=useState("");
  var validity=0;
  const onBlur = (e)=> {
    if(e.target.name==="firstName"||e.target.name==="middleName"||e.target.name==="lastName"){
      validity=ValidateTextFields(e.target.value);
    }else if(e.target.name==="mobileNumber"||e.target.name==="alternateNumber"){
      validity=ValidatePhoneNumberFields(e.target.value);
    }else if(e.target.name==="aadharNumber"){
      validity=ValidateAadharNumberFields(e.target.value);
    }else if(e.target.name==="zipCode"){
      validity=ValidateZipCodeFields(e.target.value)
    }else if(e.target.name==="panNumber"){
      validity=ValidatePanNumberFields(e.target.value)
    }else if(e.target.name==="password"){
      validity=ValidatePasswordFields(e.target.value)
    }
    setValidationStatus({...validationStatus, [e.target.name]:validity})
  }
  const checkAllFieldsValidated=()=>{
    if(validationStatus.firstName===1&&validationStatus.middleName<2&&validationStatus.password<2&&validationStatus.lastName===1&&validationStatus.aadharNumber===1&&validationStatus.mobileNumber===1&&validationStatus.alternateNumber<2&&validationStatus.zipCode<2&&validationStatus.panNumber===1){
      return true;
    }return false;
  }

  const handleGetOTP=()=>{
    if(checkAllFieldsValidated()){ // change to checkAllFieldsValidated()

    setCheckCustomerNumberExists({number : dataToRegister.mobileNumber});
    setToDisable(true);

    console.log(dataToRegister)//display debugging purposess

    http.get(getOtpURL+checkCustomerNumberExists.number)
    .then(response=>{
      if(response.data){
        window.alert("Otp Generated")
      }
      setPostPermission(response.data);//postPermisison source will only set here
    })
    .catch(err=>console.log(err.message))


    if(postPermission===false){
      setToDisable(false)// entry fields editable
    }

    }
  //   else if(dataToRegister.password!=confirmPassword) {window.alert("Reenter Password")
  // }
  else {
      window.alert("All fields are not valid yet!!!")
    }

  };

  const handleVerifyOTP=()=>{
    http.post(verifyOtpURL,otp)//change url afterwards
    .then(response=>{
      if(response.data){
        setOtpVerified(response.data)
        window.alert("Otp Verified")
      }
      console.log(response.data)})//if true 
    .catch(err=>console.log(err))
    //show registered message
  }



  const  handleRegister=()=>{
    if(otpVerified){
      http.post(adminRegistrationURL,{
        firstName:dataToRegister.firstName,
        middleName:dataToRegister.middleName,
        lastName:dataToRegister.lastName,
        mobileNumber:dataToRegister.mobileNumber,
        password:dataToRegister.password,
        alternateNumber:dataToRegister.alternateNumber,
        aadharNumber:dataToRegister.aadharNumber,
        panNumber:dataToRegister.panNumber,
        address:{
          street:dataToRegister.street,
          locality:dataToRegister.locality,
          cityOrVillage:dataToRegister.cityOrVillage,
          tahsil:dataToRegister.tahsil,
          district:dataToRegister.district,
          state:dataToRegister.state,
          zipCode:dataToRegister.zipCode},
      })//change url afterwards
      .then(response=>{
        if(response.data){
          window.alert("Data Registered")
          navigator("/adminHome")
      }})
      .catch(err=>console.log(err))
      const dataConfirmation = window.alert(
        "Name --> "+ dataToRegister.firstName+" "+dataToRegister.middleName+" "+dataToRegister.lastName+"\n"+
        "Aadhar --> "+dataToRegister.aadharNumber+"\n"+
        "Number --> "+dataToRegister.mobileNumber+"\n"+
        "Alternate Number --> "+dataToRegister.alternateNumber+"\n"+
        "Pan NUmber --> "+dataToRegister.panNumber+"\n"+
        "Address --> "+dataToRegister.address.street+", "+dataToRegister.address.locality+", "+dataToRegister.address.cityOrVillage+", "+dataToRegister.address.district+", "+dataToRegister.address.tahsil+", "+dataToRegister.address.state+", "+dataToRegister.address.zipCode+", "+"\n"
      ); // popup data
      }else{
        window.alert("otp not verified")
      }
    }


    // Registration from display
    return(<>
      <div className="row">
        <BaseLayout/>
      </div>

      <div>
        <div className="mt-5">&nbsp;</div>
        <div className="mt-5">&nbsp;</div>
      <div className="row col-6 offset-3 mt-5 mb-5 bg-light p-4 border">
        <h3><strong>Registration Details</strong></h3>

        <form className="needs-validation">
          
        <fieldset id="toDisable" disabled={toDisable}>
                  <h5><b>Personal Details</b></h5>
                    <div className="form-group row">
                      <label for="firstName" className="col-sm-5 col-form-label">First Name</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="firstName" placeholder="Rohan" onBlur={onBlur} onChange={onChange} value={dataToRegister.firstName} required/>
                      <ValidationResult condition={validationStatus.firstName}/>
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="middleName" className="col-sm-5 col-form-label">Middle Name</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="middleName" placeholder="Ashok" onBlur={onBlur} onChange={onChange} value={dataToRegister.middleName}/>
                        <ValidationResult condition={validationStatus.middleName}/>
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="lastName" className="col-sm-5 col-form-label">Last Name</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="lastName" placeholder="Shintre" onBlur={onBlur} onChange={onChange} value={dataToRegister.lastName} required/>
                        <ValidationResult condition={validationStatus.lastName}/>
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="mobileNumber" className="col-sm-5 col-form-label">Mobile Number</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="mobileNumber" placeholder="0000000000" onBlur={onBlur} onChange={onChange} value={dataToRegister.mobileNumber} required/>
                        <ValidationResult condition={validationStatus.mobileNumber}/>
                      </div>
                    </div>
                    <div className="mb-3 row">
                      <label for="username" className="col-sm-3 col-form-label">Enter Password</label>
                      <div className="col-sm-4">
                        <input type="password" className="form-control" id="password" name="password" onBlur={onBlur} onChange={onChange} value={dataToRegister.password} placeholder="minimum 8 characters with number"/>
                        <ValidationResult condition={validationStatus.password}/>
                      </div>
                    </div>
                    <div className="mb-3 row">
                      <label for="inputPassword" className="col-sm-3 col-form-label">Confirm Password</label>
                      <div className="col-sm-4">
                        <input type="password" className="form-control" id="inputPassword" name="confirmpassword" onChange={(e)=>{setConfirmPassword(e.target.value)
                        }} value={confirmPassword}/>
                      </div>
                      </div>
                    <div className="form-group row">
                      <label for="alternateNumber" className="col-sm-5 col-form-label">Alternate Mobile</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="alternateNumber" placeholder="0000000000" onBlur={onBlur} onChange={onChange} value={dataToRegister.alternateNumber}/>
                        <ValidationResult condition={validationStatus.alternateNumber}/>
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="aadharNumber" className="col-sm-5 col-form-label">Aadhar</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="aadharNumber" placeholder="000000000000" onBlur={onBlur} onChange={onChange} value={dataToRegister.aadharNumber} required/>
                        <ValidationResult condition={validationStatus.aadharNumber}/>
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="panNumber" className="col-sm-5 col-form-label">PAN</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="panNumber" placeholder="000000000000" onBlur={onBlur} onChange={onChange} value={dataToRegister.panNumber} required/>
                        <ValidationResult condition={validationStatus.panNumber}/>
                      </div>
                    </div>

                    <h5><b>Address</b></h5>
                    <div className="form-group row">
                      <label for="street" className="col-sm-5 col-form-label">Street</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="street" placeholder="Paud Road" onBlur={onBlur} onChange={onChange} value={dataToRegister.street} required/>
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="locality" className="col-sm-5 col-form-label">Locality</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="locality" placeholder="Rambaug Colony" onBlur={onBlur} onChange={onChange} value={dataToRegister.locality} required/>
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="cityOrVillage" className="col-sm-5 col-form-label">Village/City</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="cityOrVillage" placeholder="Pune" onBlur={onBlur} onChange={onChange} value={dataToRegister.cityOrVillage} required/>
                      </div>
                    </div>



                    <div className="form-group row">
                      <label for="tahsil" className="col-sm-5 col-form-label">Tahsil</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="tahsil" placeholder="Pune" onBlur={onBlur} onChange={onChange} value={dataToRegister.tahsil} required/>
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="district" className="col-sm-5 col-form-label">District</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="district" placeholder="Pune" onBlur={onBlur} onChange={onChange} value={dataToRegister.district} required/>
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="state" className="col-sm-5 col-form-label">State</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="state" placeholder="Maharashtra" onBlur={onBlur} onChange={onChange} value={dataToRegister.state} required/>
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="zipCode" className="col-sm-5 col-form-label">Zip Code</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="zipCode" placeholder="411046" onChange={onChange} value={dataToRegister.zipCode} required/>
                        <ValidationResult condition={validationStatus.zipCode}/>
                      </div>
                    </div>

                    
                  </fieldset>
                    <div className="col-10 mb-3 row offset-2" >
                      <button type="button" className="btn btn-warning col-sm-3 col-form" name="btnGetOTP" onClick={handleGetOTP}>Get OTP</button>
                      <div className="col-sm-6">
                        <input type="text" className="form-control col-form-control" name="otp" placeholder="Enter OTP" onChange={handleOTP} value={otp.otp} required/>
                        <button type="button" className="btn btn-primary col-sm-3 col-form" name="btnVerifyOTP" onClick={handleVerifyOTP}>Verify OTP</button>
                      </div>
                    </div>

                    <div className="form-group row offset-4" >
                      
                      <div class="col-sm-10">
                        <button type="button" className="btn btn-primary"  name="btnRegister" onClick={handleRegister}>Register</button>
                    </div>
                    </div>
        </form>
      </div>
      </div>

      <div className="row mt-5">
        <Footer/>
      </div>
      
</>)
}
export default AdminRegistration;