import react from "react";
import Footer from './Footer'
import BaseLayout from '../BaseLayout'

function Contact(){
    return (
        <div className="row">
            <div className="row">
                  <BaseLayout/>
            </div>

         <div className="mt-5">&nbsp;</div>
         <div className="mt-5">&nbsp;</div>  

         <div> <h1><strong> <i>Email us on : info@digitalbhishi.online </i></strong></h1> </div>    
         <div> <h2><strong> Meet our Team</strong></h2> </div>                 
             
         <div className="mt-5 ">
         <table className="table table-bordered border-danger" style={{fontSize:"34px"}}>
                <tr className="table-primary">
                  <th className="table-primary"> Name</th>
                  <th className="table-secondary">Mobile Number</th>
                  <th className="table-success">Email</th>
                  <th className="table-light"></th>
                  </tr>

                  <tr className="table-primary">
                  <td className="table-primary">Rohan Ashok Shintre</td>
                  <td className="table-secondary">+91 7083310387</td>
                  <td className="table-success">rohan@digitalbhishi.online </td>
                  <td className="table-dark"> <button type="button" class="btn btn-primary btn-sm"><a href="http://www.linkedin.com/in/ShintreRohan" target="_blank" style={{color:"white",textDecoration:"none"}}>Profile</a></button></td>
                  </tr>

                  <tr className="table-primary">
                  <td className="table-primary">Gourab Karmakar</td>
                  <td className="table-secondary">+91 9830707310</td>
                  <td className="table-success">gaurab@digitalbhishi.online</td>
                  <td className="table-dark"> <button type="button" class="btn btn-primary btn-sm"><a href="https://www.linkedin.com/in/gourab-karmakar-5570b2187" target="_blank" style={{color:"white",textDecoration:"none"}}>Profile</a></button></td>
                  </tr>
                 
                  <tr className="table-primary">
                  <td className="table-primary">Aditya Darade</td>
                  <td className="table-secondary">+91 9545105137</td>
                  <td className="table-success">aditya@digitalbhishi.online</td>
                  <td className="table-dark"> <button type="button" class="btn btn-primary btn-sm"><a href="https://www.linkedin.com/in/aditya-darade-339355260" target="_blank" style={{color:"white",textDecoration:"none"}}>Profile</a></button></td>
                  </tr>

                  
                  <tr className="table-primary">
                  <td className="table-primary">Gaurav Purohit</td>
                  <td className="table-secondary">+91 8778789692</td>
                  <td className="table-success">gaurav@digitalbhishi.online</td>
                  <td className="table-dark"> <button type="button" class="btn btn-primary btn-sm"><a href="https://www.linkedin.com/in/gaurav-purohit-a6900612b" target="_blank" style={{color:"white",textDecoration:"none"}}>Profile</a></button></td>
                  </tr>
                            
         </table>
         </div>


        <div className="row mt-5">
            <Footer/>
        </div>
                             
        </div>
    )
}

export default Contact;