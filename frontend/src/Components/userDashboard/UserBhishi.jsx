import React,{useState} from 'react'
import UserNavbar from '../UserNavbar'
import http from '../../httpCommon'
import { HiCheck } from 'react-icons/hi'
const UserBhishi=()=> {
    const [userBhishiDetails,setUserBhishiDetails]=useState({})
    const bhishiDetailsURL="/customerDashboard-getBhishi"
    const payURL = "/newPayment/"
    const [status,setStatus]=useState("none");
    const [payAmount, setPayAmount]=useState(0);


const onChange=(e)=>{
    setPayAmount(e.target.value);
}
    const handlePay=()=>{
        http.get(payURL+payAmount)
        .then(response=>{
            window.location.replace(response.data)
        })
        .catch(err=>{console.log(err)})
    }

    const handleGetBhishi=()=>{
        setStatus("inline")
        http.get(bhishiDetailsURL)
        .then(response=>{
            setUserBhishiDetails(response.data)
            console.log(response.data);
        })
    }
    
    return (<>

    <div className="row ">
        <UserNavbar/>
    </div>
    <div className="mb-5">&nbsp;</div>
    <div className="mb-5">&nbsp;</div>
        <div className="row mt-5 grid-container">
            <button type="button" className="col-3 mb-2 btn btn-warning" onClick={handleGetBhishi}>Get MyBhishi</button>
        </div>
        <div className='row grid-container'>
        <table className="table-primary border-5" style={{display:status}}>
                <thead>
                  <tr className="table-primary">
                    <td className="table-primary">start Date </td>
                    <td></td>
                    <td className="table-primary">maturity Date </td>
                    <td></td>
                    <td className="table-primary">paid Up </td>
                    <td></td>
                    <td className="table-secondary"> Amount</td>
                    </tr>
                  </thead>
                  <tbody>
                      <tr>
                            <td className="me-3">{userBhishiDetails.startDate}</td>
                            <td></td>
                            <td className="me-3">{userBhishiDetails.maturityDate}</td>
                            <td></td>
                            <td className="me-3">{userBhishiDetails.paidUpValues}</td>
                            <td></td>
                            <td className="me-3"><input type="text" value={payAmount} className="form-control" onChange={onChange}/></td>
                            <td></td>
                            <td className="me-3"> <button type="button" className="btn btn-danger" onClick={handlePay}>Pay Now</button></td>
                </tr>
                </tbody>
</table>
        </div>
        </>
    )
}

export default UserBhishi;
