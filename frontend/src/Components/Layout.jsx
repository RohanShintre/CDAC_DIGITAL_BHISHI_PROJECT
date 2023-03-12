import { Outlet } from "react-router-dom";

const Layout = ()=>{
    return (
        <div className="App container-fluid bgimage">
            <Outlet/>
        </div>

        )
}

export default Layout;