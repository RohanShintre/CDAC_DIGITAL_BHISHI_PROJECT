import React from 'react'
import "./Home.css"

function Slider() {
return (
    <div className="d-flex" >
        <div id="carouselExampleControls" className="carousel slide" data-bs-ride="carousel">
        <div className="carousel-inner slidersizer">
            <div className="carousel-item active">
            <img src="back.jpg" className="d-block " alt="..." style={{height :"100vh" ,width:"98vw"}}/>
            </div>
            <div className="carousel-item">
            <img src="homeback.jpg" className="d-block " alt="..." style={{height :"100vh" ,width:"98vw"}}/>
            </div>
            <div className="carousel-item">
            <img src="home.jpg" className="d-block " alt="..." style={{height :"100vh" ,width:"98vw"}}/>
            </div>
        </div>
        <button className="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
            <span className="carousel-control-prev-icon" aria-hidden="true"></span>
            <span className="visually-hidden">Previous</span>
        </button>
        <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
            <span className="carousel-control-next-icon" aria-hidden="true"></span>
            <span className="visually-hidden">Next</span>
        </button>
        </div>
    </div>
)
}

export default Slider