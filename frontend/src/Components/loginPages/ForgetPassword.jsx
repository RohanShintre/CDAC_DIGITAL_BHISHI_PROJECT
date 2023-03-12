import React from "react";
import "./ResetPassword";
import BaseLayout from "../BaseLayout";
import Footer from "../home/Footer";
import { useNavigate } from "react-router-dom";

const ForgetPassword=()=>{
  const navigator=useNavigate();
  function handleNav(){
    navigator("/resetPassword")
  }
    return  <>
    
    <div className="row">
        <BaseLayout/>
      </div>
      <div className="mt-5">&nbsp;</div>
         <div className="mt-5">&nbsp;</div>
         <div className="col-5 mt-5 mb-5 offset-3 bg-light row p-4 border">
        <h3 className="text-center mb-4">Forget Password</h3>
          <div className="mb-3 row">
        <div className="col-10 offset-2">
          <input type="text" className="form-control flex-row" id="username" placeholder="Mobile Number"/>
          </div>
        </div>

          <div className="col-12 mb-6 row" >
          <button type="button" className="btn btn-warning col-3 offset-2 col-form flex-row">Get OTP</button>
          <div className="col">
      <input type="text" className="form-control col-form-control flex-row" placeholder="Enter OTP"/>
    </div>
  </div>

      <div className="col-12 mt-3 text-center">
      <button className="btn btn-danger col-3 flex-row" onClick={handleNav} type="button">Submit</button>
    </div>

</div>
<div className="row">
<Footer/>
</div>

</>
}
export default ForgetPassword;