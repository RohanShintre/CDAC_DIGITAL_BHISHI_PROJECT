import React from 'react'
import UserNavbar from '../UserNavbar'
import {useState, useEffect} from 'react';
import http from '../../httpCommon';

const UserProfile=()=> {
  const customerProfileURL = "/customerDashboard-getProfile/"
  const [userDetails, setUserDetails]=useState({
    firstName:"",
    middleName:"",
    lastName:"",
    primaryNumber:"",
    alternateNumber:"",
    customerAadhar:"",
    guarantor1Aadhar:"",
    guarantor2Aadhar:"",
    street:"",
    locality:"",
    villageOrCity:"",
    tahsil:"",
    district:"",
    state:"",
    zipCode:"",
  })

  useEffect(()=>{
    http.get(customerProfileURL)
    .then(response=>{
      console.log(response.data)
      setUserDetails({
        firstName:response.data?.firstName,
    middleName:response.data?.middleName,
    lastName:response.data?.lastName,
    primaryNumber:response.data?.mobileNumber,
    alternateNumber:response.data?.alternateNumber,
    customerAadhar:response.data?.aadharNumber,
    guarantor1Aadhar:response.data?.guarantor1Aadhar,
    guarantor2Aadhar:response.data?.guarantor2Aadhar,
    street:response.data?.street,
    locality:response.data?.locality,
    villageOrCity:response.data?.villageOrCity,
    tahsil:response.data?.tahsil,
    district:response.data?.district,
    state:response.data?.state,
    zipCode:response.data?.zipCode,
      })
    })
    .catch(error=>console.log(error.message))
  },[])


    return (<>
        <div className="row">
          <UserNavbar/>
        </div>

        <div>
        <div className="mt-5">&nbsp;</div>
        <div className="mt-5">&nbsp;</div>
        
        <div className="row col-6 offset-3 mt-5 mb-5 bg-light p-4 border">
        <form className="needs-validation">
              
                  <h5><b>Personal Details</b></h5>
                    <div className="form-group row">
                      <label for="firstName" className="col-sm-5 col-form-label">First Name</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="firstName" placeholder="Rohan"value={userDetails.firstName} />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="middleName" className="col-sm-5 col-form-label">Middle Name</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="middleName" placeholder="Ashok"value={userDetails.middleName} />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="lastName" className="col-sm-5 col-form-label">Last Name</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="lastName" placeholder="Shintre"value={userDetails.lastName} />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="primaryNumber" className="col-sm-5 col-form-label">Mobile Number</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="primaryNumber" placeholder="0000000000"value={userDetails.mobileNumber} />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="alternateNumber" className="col-sm-5 col-form-label">Alternate Mobile</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="alternateNumber" placeholder="0000000000"value={userDetails.alternateNumber} />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="customerAadhar" className="col-sm-5 col-form-label">Aadhar</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="customerAadhar" placeholder="000000000000"value={userDetails.customerAadhar} />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="guarantor1Aadhar" className="col-sm-5 col-form-label">Guarantor1 Aadhar</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="guarantor1Aadhar" placeholder="000000000000"value={userDetails.guarantor1Aadhar} />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="guarantor2Aadhar" className="col-sm-5 col-form-label">Guarantor2 Aadhar</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="guarantor2Aadhar" placeholder="000000000000"value={userDetails.guarantor2Aadhar} />
                      </div>
                    </div>

                    <h5><b>Address</b></h5>
                    <div className="form-group row">
                      <label for="street" className="col-sm-5 col-form-label">Street</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="street" placeholder="Paud Road"value={userDetails.street} />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="locality" className="col-sm-5 col-form-label">Locality</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="locality" placeholder="Rambaug Colony"value={userDetails.locality} />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="villageOrCity" className="col-sm-5 col-form-label">Village/City</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="villageOrCity" placeholder="Pune"value={userDetails.villageOrCity} />
                      </div>
                    </div>



                    <div className="form-group row">
                      <label for="tahsil" className="col-sm-5 col-form-label">Tahsil</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="tahsil" placeholder="Pune"value={userDetails.tahsil} />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="district" className="col-sm-5 col-form-label">District</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="district" placeholder="Pune"value={userDetails.district} />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="state" className="col-sm-5 col-form-label">State</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="state" placeholder="Maharashtra"value={userDetails.state} />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="zipCode" className="col-sm-5 col-form-label">Zip Code</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="zipCode" placeholder="411046"value={userDetails.zipCode} />
                      </div>
                    </div>

        </form>
      </div>
      </div>
        
        </>
    )
}

export default UserProfile;
