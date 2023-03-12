import React from "react";

const GeneratePassword =()=>{

    return <div  className="grid-container col-10 offset-3 mt-5 ">
        <h3 className="displaymid">Generate  Password</h3>
      <div className="mb-3 row">
    <label for="username" className="col-sm-3 col-form-label">Enter Password</label>
    <div className="col-sm-4">
    <input type="text" className="form-control" id="username"/>
    </div>
  </div>
  <div className="mb-3 row">
    <label for="inputPassword" className="col-sm-3 col-form-label">Confirm Password</label>
    <div className="col-sm-4">
      <input type="password" className="form-control" id="inputPassword"/>
    </div>
  </div>

  <div className="col-4 mt-3 offset-4">
    <a class="btn btn-danger" href="http://localhost:3000/" role="button">Submit</a>
    </div>

    </div>
}

export default GeneratePassword;