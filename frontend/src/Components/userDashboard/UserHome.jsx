import React from 'react'
import UserNavbar from '../UserNavbar'
import Slider from '../home/Slider';

const UserHome=()=> {
    return (<>

<div className="row">
                  <UserNavbar/>
                </div>

                <div className="row ">
                  <Slider/>
                </div>
        
        </>
    )
}

export default UserHome
