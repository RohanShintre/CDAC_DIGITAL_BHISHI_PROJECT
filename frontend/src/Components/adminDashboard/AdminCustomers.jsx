import React,{useState} from 'react'
import Navbar from '../Navbar';
import backgroundImage from "./backdashboard.jpg"
import http from '../../httpCommon'

const AdminCustomers = () => {
  const requestURL="/AdminDashboard-getAllCustomers"
  const [customers, setCustomers]=useState([])
  const handleGetCustomers=()=>{
    http.get(requestURL)
    .then(response=>{
      console.log(response.data)
      setCustomers(response.data)
    })
    .catch(err=>{console.log(err)})
  }
    return (<>

      <div className='mt-3'>
          <Navbar/>
      </div>

      
      <div className="row mt-5">&nbsp;</div>
        <div className="row mt-5">&nbsp;</div>
        <div className="row mt-5">&nbsp;</div>
        
        <div className="row p-3 grid-container">
        <button type="button" className='btn btn-warning col-2' onClick={handleGetCustomers}>Show Registered Customers</button>
        </div>
      <div className='ms-1 mt-2 row'>
            <table className="table-primary border-5">
                <thead>
                  <tr className="table-primary">
                    <td className="table-primary">Full Name </td>
                    <td className="table-primary">Middle Name </td>
                    <td className="table-primary">last Name </td>
                    <td className="table-secondary">Mobile Number </td>
                    </tr>
                  </thead>
                  <tbody>
                {customers.map((customer,index)=>{
                  return (<tr key={index}>
                            <td className="me-3">{customer.firstName}</td>
                            <td>{customer.middleName}</td>
                            <td>{customer.lastName}</td>
                            <td className="me-3">{customer.mobileNumber}</td>
                  </tr>);
                })}
                </tbody>

                  
            </table>
      </div>

      

    </>
    )
}
export default AdminCustomers;