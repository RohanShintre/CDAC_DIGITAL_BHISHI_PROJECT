import React from 'react';
import {useNavigate} from 'react-router-dom';
import http from '../../httpCommon'
const Logout=()=>{
    const navigator=useNavigate();

    const redirect=()=>{
        
    }
    
    http.get("/logout")
    .then(()=>{navigator("../", {replace : true})})
    .catch(err=>console.log(err))
    return (
        <></>  
    );
}
export default Logout;
