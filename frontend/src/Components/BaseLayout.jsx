import { useNavigate } from "react-router-dom";
import './BaseLayout.css';

const BaseLayout=()=>{
const navigator=useNavigate();

const navHome=()=>{
    navigator("/")
}

function navLogin(){
    navigator("/login")
}

function navRegistration(){
    navigator("/registration")
}

function navAbout(){
    navigator("/about")
}

function navContactUs(){
    navigator("/contact")
}

    return (<>
        <div className="header">
                <div className="title row" >
                    <div className="titlebar col mb-2">
                    <img className="titlelogo" src="logo.jpg" />Digital Bhishi</div>
                </div>
                <hr/>
                
                <div className="row grid-container">
                        <a  className="btn btn-success col-1 text-center me-2" onClick={navHome}>HOME</a>
                        <a  className="btn btn-outline-dark col-1 text-center me-2" onClick={navLogin} >SIGN IN</a>
                        <a  className="btn btn-success col-1 text-center me-2" onClick={navRegistration} >SIGN UP</a>
                        <a  className="btn btn-outline-dark col-1 text-center me-2" onClick={navAbout} >ABOUT</a>
                        <a  className="btn btn-success col-1 text-start text-center" onClick={navContactUs} >CONTACT </a>
                </div>
        </div>
                
        </>
    );
}

export default BaseLayout;