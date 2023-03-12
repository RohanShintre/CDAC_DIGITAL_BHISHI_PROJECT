import React,{useEffect} from "react";
import Slider from './Slider'
import Footer from './Footer'
import BaseLayout from '../BaseLayout'

const Home=()=>{
  
    return (  <>
                <div className="row">
                  <BaseLayout/>
                </div>
                <hr/>
                <div className="row ">
                  <Slider/>
                </div>
                <div className="row">
                  <Footer/>
                </div>
              </>
    )
}

export default Home;