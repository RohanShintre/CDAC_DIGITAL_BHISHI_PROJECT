import react from "react";
import Footer from './Footer'
import BaseLayout from '../BaseLayout'

function About(){
    return (
        <div className="row">
            <div>
                  <BaseLayout/>
            </div>

         <div className="mt-5">&nbsp;</div>
         <div className="mt-5">&nbsp;</div>                   
         <div className="row offset-2 col-8 mt-5">

            <h1 className="fw-bold"><strong>Digital Bhishi</strong></h1>
            <hr className="mb-4 mt-0 d-inline-block mx-auto" style={{ width: "60px", backgroundColor: "#7c4dff", height: "2px" }} />
            <p>
                “       In the rural areas especially in the Western part of Maharashtra, there are a huge number of villages where the concept called as “Bhishi” has been carried out since long ago. The survey states that all operations are carried out manually. There is a huge amount of work which needs lots of effort to perform. There are huge amounts of complex calculations involved in the process. Also the major task of record keeping is being done by traditional notebook methods.The project mainly focuses to reduce all manual efforts and provide ease of operation to both customers and administrative bodies. It will ensure the transparency of business as the financial transactions have been involved.The motivation is taken from the principle of bank working and the same is implemented in a different way as per the need."
            </p>
            <p>
                In almost every village there is a concept called “Bhishi”. The customers are provided with a passbook and the same is updated by the respective executive of the body. Also there are some loan transactions between customer and administration so the record must be maintained at both the ends which is done manually at present.
                The App which can manage all the stuff digitally with minimum effort and yet in a very effective and accurate manner will definitely help to increase the transparency of business. Moreover, it will reduce the transaction time by a lot with reduction of mistakes or errors associated with complex calculations.
                There is a very wide scope as almost all the work is being done manually at the current time and hence there is a huge demand in the rural regions of India for such kind of software solution.
                As per our team survey no attempts have been made to address and solve this problem digitally.
            </p>
        </div>


        <div className="row mt-5">
            <Footer/>
        </div>
                             
        </div>
    )
}

export default About;