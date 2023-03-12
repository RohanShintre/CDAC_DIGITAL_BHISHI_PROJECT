
import { Routes,Route } from 'react-router-dom';
import './App.css';
import './Components/home/Home.css';

import Layout from './Components/Layout'
import Missing from './Components/Missing'
import Unauthorised from './Components/Unauthorised'

import About from "./Components/home/About"
import Contact from "./Components/home/Contact"
import Login from "./Components/loginPages/Login"
import ForgetPassword from './Components/loginPages/ForgetPassword';
import ResetPassword from './Components/loginPages/ResetPassword';
import Registration from "./Components/registrationPages/Registration"
import GeneratePassword from "./Components/registrationPages/GeneratePassword";
import Home from "./Components/home/Home"
import Logout from './Components/loginPages/Logout'

import AdminHome from "./Components/adminDashboard/AdminHome"
import AdminProfile from "./Components/adminDashboard/AdminProfile"
import AdminCustomers from "./Components/adminDashboard/AdminCustomers"
import AdminRequest from "./Components/adminDashboard/AdminRequest"

import UserHome from "./Components/userDashboard/UserHome"
import UserProfile from "./Components/userDashboard/UserProfile"
import UserBhishi from "./Components/userDashboard/UserBhishi"
import UserLoan from "./Components/userDashboard/UserLoan"

import './App.css';
import AdminRegistration from './Components/registrationPages/AdminRegistration';


function App() {
  return (

      <Routes>
        <Route path="/" element={<Layout />} >
        {/*public url */}
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/login" element={<Login />} />
          <Route path="registration" element={<Registration />} />
          <Route path="/forgetPassword" element={<ForgetPassword />} />
          <Route path="/resetPassword" element={<ResetPassword />} />
          <Route path="/generatePassword" element={<GeneratePassword />} />
          <Route path='/unauthorised' element={<Unauthorised />} />
          <Route path="/logout" element={<Logout/>}/>
        {/*private admin url */}
        {/*<Route element={<RequireAuth allowedRoles={[1988]} />} >*/}
          <Route path="/adminHome" element={<AdminHome />} />
          <Route path="/adminProfile" element={<AdminProfile />} />
          <Route path="/adminCustomers" element={<AdminCustomers />} />
          <Route path="/adminRequest" element={<AdminRequest />} />
          <Route path="adminRegistration" element={<AdminRegistration />}/>
        {/*</Route> */}
        {/*private customer url */}
        {/*<Route element={<RequireAuth allowedRoles={[3002]} />} >*/}
          <Route path="/userHome" element={<UserHome />} />
          <Route path="/userProfile" element={<UserProfile />} />
          <Route path="/userbhishi" element={<UserBhishi />} />
          <Route path="/userLoan" element={<UserLoan />} />
          
        {/*</Route> */}
          {/* missing */}
          <Route path="*" element={<Missing/>}/>
          </Route>
      </Routes>
  );
}

export default App;
