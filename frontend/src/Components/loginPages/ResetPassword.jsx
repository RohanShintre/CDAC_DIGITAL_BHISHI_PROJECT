import React from "react";
import "../home/Home";
import BaseLayout from "../BaseLayout";
import Footer from "../home/Footer";
import { useNavigate } from "react-router-dom";


const ResetPassword=()=>{
  const navigator=useNavigate();
  const handleHome=()=>{
    alert("Your Password has been reset");
    navigator('/')
  }
    return <>
    <div className="row">
      <BaseLayout/>
    </div>
    <div  className="row col-4 p-5 offset-4 bg-light mt-5 mb-5 border text-center">
        <h3>Reset Password</h3>
      <div className="row mb-3">
        <div className="col-12 flex-row">
          <input type="text" className="form-control" id="username" placeholder="New Password"/>
        </div>
      </div>
      <div className="mb-3 row">
        <div className="col-12 flex-row">
          <input type="password" className="form-control" id="inputPassword" placeholder="Confirm Password"/>
        </div>
      </div>

  <div className="col-4 mt-3 mb-3 offset-4">
      <a class="btn btn-danger" role="button" onClick={handleHome}>Submit</a>{//change this link to a fucntion
      }
    </div>

    </div>
    <div className="row">
      <Footer/>
    </div>

    </>
}
export default ResetPassword;