import { useNavigate } from "react-router-dom"

const Unauthorised=()=> {

    const navigate=useNavigate();
    const goBack =()=>navigate(-1);

    return (
    <div><h1>Unauthorised</h1>
    
    <button type="button" className="btn" onClick={goBack}>Go back</button>
    
    </div>

    )
}

export default Unauthorised