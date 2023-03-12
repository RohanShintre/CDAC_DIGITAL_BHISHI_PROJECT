import React,{useState} from 'react'
import http from '../../httpCommon'
import Navbar from '../Navbar'
import backgroundImage from "./backdashboard.jpg"
import { HiTicket } from 'react-icons/hi'

const AdminRequest=()=> {
  const requestURL="/AdminDashboard-getAllNewCustomers"  
  const sendDataURL="/AdminDashboard-approveCustomer/"
  const [customers, setCustomers]=useState([])
  const [bhishiDetails]= useState({
    startDate:undefined,maturityDate:undefined, premium:200,paidUp:0, isActive:true, transactionStatus:0//default values
  })
  const handleGetRequest=()=>{
    http.get(requestURL)
    .then(response=>{
      console.log(response.data)
      setCustomers(response.data)
    })
    .catch(err=>{console.log(err)})
  }
  const createDate=()=>{
  //   var y = new Date().getFullYear();
  //   var m = new Date().getMonth();
  //   var d = new Date().getDate();
  //   return y+"-"+m+"-"+d;
  const date = new Date();
  const isoString = date.toISOString();
return isoString;    


}
  const getEndDate=(date)=>{
    var y=parseInt(date.substring(0,4))+1
    var m=date.substring(5,7);
    var d=date.substring(8,10);
    return  y+"-"+m+"-"+d;
  }
  const handleApprove=(e)=>{
    var currentDate=createDate();
    //var endDate=getEndDate(currentDate);
    http.post(sendDataURL+e.target.value,{
      startDate:currentDate,maturityDate:currentDate, premium:200,paidUp:0, isActive:true, transactionStatus:0
    })
    .then(response=>{console.log(response.data)})
    .catch(err=>{console.log(err)})
  }
    
    return (<>


      <div className='mt-3 row'>
          <Navbar/>
        </div>

        <div className="row mt-5">&nbsp;</div>
        <div className="row mt-5">&nbsp;</div>
        <div className="row mt-5">&nbsp;</div>
        
        <div className="row p-3 grid-container">
        <button type="button" className='btn btn-warning col-2' onClick={handleGetRequest}>Show New Bhishi Applicants</button>
        </div>
      <div className='ms-1 mt-2 row'>
            <table className="table-primary border-5">
                <thead>
                  <tr className="table-primary">
                    <td className="table-primary">Full Name </td>
                    <td className="table-primary">middle Name </td>
                    <td className="table-primary">last Name </td>
                    <td className="table-secondary">Mobile Number   </td>
                    <td className="table-light ">Approve Customer </td>
                    </tr>
                  </thead>
                  <tbody>
                {customers.map((customer,index)=>{
                  return (<tr key={index}>
                            <td className="me-3">{customer.firstName}</td>
                            <td className="me-3">{customer.middleName}</td>
                            <td className="me-3">{customer.lastName}</td>
                            <td className="me-3">{customer.mobileNumber}</td>
                            <td className="me-3"> <button value={customer.newCustomerId} type="button" name={index} onClick={handleApprove}>Approve</button></td>
                  </tr>);
                })}
                </tbody>

                  
            </table>
      </div>
      
        
        </>
    )
}

export default AdminRequest
