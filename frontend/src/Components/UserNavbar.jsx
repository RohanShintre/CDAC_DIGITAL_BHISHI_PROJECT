import React from 'react'
import { useNavigate } from 'react-router-dom'

const UserNavbar=({children})=> {
const navigator=useNavigate();
const handleHome=()=>{
    navigator("/userHome")
}
const handleProfile=()=>{
    navigator("/userProfile")
}

const handleBhishi=()=>{
  navigator("/userBhishi")
}

const handleLoan=()=>{
  navigator("/userLoan")
}

const handleLogout=()=>{
  navigator("/")
}

    return (
      <div className="header ">
      <div className="title row" >
          <div className="titlebar col mb-2">
          <img className="titlelogo" src="logo.jpg" />Customer Portal</div>
      </div>
      <hr/>
      
      <div className="row grid-container">
              <a  className="btn btn-primary col-1 text-start text-center me-2" onClick={handleLogout} >LOGOUT </a>
              <a  className="btn btn-outline-secondary col-1 text-center me-2" onClick={handleHome}>HOME</a>
              <a  className="btn btn-outline-secondary col-1 text-center me-2" onClick={handleProfile} >PROFILE</a>
              <a  className="btn btn-outline-secondary col-1 text-center me-2" onClick={handleBhishi} >MyBHISHI</a>
              <a  className="btn btn-outline-secondary col-1 text-center me-2" onClick={handleLoan} >MyLoan</a>
      </div>
</div>      
    )
}

export default UserNavbar;
