import React from 'react'
import Navbar from '../Navbar';

const AdminProfile = () => {
    return (<>
                <div className="row">
                  <Navbar/>
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
                        <input type="text" className="form-control" name="firstName" placeholder="Rohan"/>
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="middleName" className="col-sm-5 col-form-label">Middle Name</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="middleName" placeholder="Ashok" />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="lastName" className="col-sm-5 col-form-label">Last Name</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="lastName" placeholder="Shintre" />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="primaryNumber" className="col-sm-5 col-form-label">Mobile Number</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="primaryNumber" placeholder="0000000000" />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="alternateNumber" className="col-sm-5 col-form-label">Alternate Mobile</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="alternateNumber" placeholder="0000000000" />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="customerAadhar" className="col-sm-5 col-form-label">Aadhar</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="customerAadhar" placeholder="000000000000" />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="guarantor1Aadhar" className="col-sm-5 col-form-label">Guarantor1 Aadhar</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="guarantor1Aadhar" placeholder="000000000000" />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="guarantor2Aadhar" className="col-sm-5 col-form-label">Guarantor2 Aadhar</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="guarantor2Aadhar" placeholder="000000000000" />
                      </div>
                    </div>

                    <h5><b>Address</b></h5>
                    <div className="form-group row">
                      <label for="street" className="col-sm-5 col-form-label">Street</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="street" placeholder="Paud Road" />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="locality" className="col-sm-5 col-form-label">Locality</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="locality" placeholder="Rambaug Colony" />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="villageOrCity" className="col-sm-5 col-form-label">Village/City</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="villageOrCity" placeholder="Pune"/>
                      </div>
                    </div>



                    <div className="form-group row">
                      <label for="tahsil" className="col-sm-5 col-form-label">Tahsil</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="tahsil" placeholder="Pune" />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="district" className="col-sm-5 col-form-label">District</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="district" placeholder="Pune" />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="state" className="col-sm-5 col-form-label">State</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="state" placeholder="Maharashtra" />
                      </div>
                    </div>

                    <div className="form-group row">
                      <label for="zipCode" className="col-sm-5 col-form-label">Zip Code</label>
                      <div className="col-sm-6">
                        <input type="text" className="form-control" name="zipCode" placeholder="411046" />
                      </div>
                    </div>

                    
                    <div className="form-group row offset-4" >
                    <div class="col-sm-10 mt-5">
                        <button type="button" className="btn btn-primary"  name="btnRegister" >Edit</button>
                    </div>
                    </div>
        </form>
      </div>
      </div>
   
 
    </>
    )
}
export default AdminProfile;