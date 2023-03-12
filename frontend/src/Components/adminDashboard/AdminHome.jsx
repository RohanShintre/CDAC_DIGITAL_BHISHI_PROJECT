import React, {useState} from 'react'
import Navbar from '../Navbar'
import { useNavigate } from 'react-router-dom';
import { HiPlus } from 'react-icons/hi';
import http from '../../httpCommon'

const AdminHome=()=> {
  const sendDataURL = "/"
  const navigator=useNavigate();
  const [date,setDate] = useState("00-00-0000");
  const [convertedDate, setConvertedDate]=useState(()=>date.substring(6,10)+"-"+date.substring(3,5)+"-"+date.substring(0,2));
  const [bhishiDataToSend , setBhishiDataToSend]=useState({
    startDate:"",
    endDate:"",
    premium:0,
    isActive:false,
    paidUp:0,
    terminationStatus:0
  })
  const [tableProperty, setTableProperty]=useState("none");

  const handleCreateBhishiTable=()=>{
    setTableProperty("inline")
  }

  const handleAddNewAdmin=()=>{
    navigator("/adminRegistration")
  }

  const onChange=(e)=>{
    setBhishiDataToSend({...bhishiDataToSend, [e.target.name]:e.target.value})
    if(Object.keys(e.target.name).includes("startDate")){
      var y=parseInt(bhishiDataToSend.startDate.substring(6,10))+1
      var m = bhishiDataToSend.startDate.substring(3,5)
      var d = bhishiDataToSend.startDate.substring(0,2);
      var ad = d+m+y;
      setBhishiDataToSend({endDate:ad})
    }
  }
  
  const createBhishi=()=>{
    http.post()
  }

    return (<>
                <div className="row">
                <div className="row mt-5">
                  <Navbar/>
                </div>

                <div className="row mt-5 grind-container">
                  <h1 className="text-center mt-5 col">Welcome to home</h1>
                  <button className="btn btn-warning col-2 me-3" type="button" onClick={handleAddNewAdmin}><HiPlus size={40}/> Add New Admin</button>
                  {/* <button className="btn btn-danger col-2 " type="button" onClick={handleCreateBhishiTable}><HiPlus size={40}/> Add New Bhishi</button> */}
                </div>
                </div>
                <div className='row grid-container col-6' style={{display:"none"}}>
                  <ul>
                    <li className='col-4 text-center'>
                      <label className="" >Start Date</label>
                    </li>
                    <li className='col-4'>
                      <input type="date" id="sd" min={date} onChange={onChange} value={bhishiDataToSend.startDate} name="startDate" className="form-control" placeholder="Start Date" />
                    </li>
                    <li className='col-4 text-center'>
                      <label className="" >Enter Premium</label>
                    </li>
                    <li className='col-4'>
                      <input type="text" onChange={onChange} value={bhishiDataToSend.premium} name="premium" className="form-control" placeholder="Premium" />
                    </li>
                    <li className='col-4'>
                      <input type="button" name="createBhishi" className="btn btn-danger" value="Create" onClick={createBhishi} />
                    </li>
                  </ul>
                </div>
        </>
    )
}

export default AdminHome
