import React from 'react'
import { useNavigate } from 'react-router-dom'
import http from '../httpCommon';

const Navbar=({children})=> {
const navigator=useNavigate();
const handleHome=()=>{
    navigator("/adminHome")
}
const handleProfile=()=>{
    navigator("/adminProfile")
}

const handleRequest=()=>{
  navigator("/adminRequest")
}

const handleCustomers=()=>{
  navigator("/adminCustomers")
}
const handleLogout=()=>{
  http.get("/logout")
  .then(response=>{
    console.log("session endded")
  }).catch(err=>console.log(err))
  navigator('/login',{replace:true});
}

    return (<>
      <div className="header ">
                <div className="title row" >
                    <div className="titlebar col mb-2">
                    <img className="titlelogo" src="logo.jpg" />Admin Portal</div>
                </div>
                <hr/>
                
                <div className="row grid-container">
                        <a  className="btn btn-primary col-1 text-start text-center me-2" onClick={handleLogout} >LOGOUT </a>
                        <a  className="btn btn-outline-secondary col-1 text-center me-2" onClick={handleHome}>HOME</a>
                        <a  className="btn btn-outline-secondary col-1 text-center me-2" onClick={handleProfile} >PROFILE</a>
                        <a  className="btn btn-outline-secondary col-1 text-center me-2" onClick={handleCustomers} >CUSTOMERS</a>
                        <a  className="btn btn-outline-secondary col-1 text-center me-2" onClick={handleRequest} >REQUEST</a>
                </div>
        </div>
  </>
        
    )
}

export default Navbar
