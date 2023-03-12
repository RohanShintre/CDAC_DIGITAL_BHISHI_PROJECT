import { HiXCircle, HiCheckCircle } from "react-icons/hi";
const ValidationResult=(props)=>{
    if(props.condition===0){
        return <span className="col"></span>
    }else if(props.condition===1){return <HiCheckCircle className="col" size="2rem" color="green" display="inline"/>
    }else return <HiXCircle className="col" size="2rem" color="red" display="inline"/>
}


function ValidateTextFields(text){
    let testText=/^[a-z]+$/i
    if(text.match(testText)){
        return 1;
    }
    return 2;
}

function ValidatePhoneNumberFields(text){
    let testText=/^[0-9]{10,10}$/
    if(text.match(testText)){
        return 1;
    }
    return 2;
}

function ValidateAadharNumberFields(text){
    let testText=/^[0-9]{12,12}$/
    if(text.match(testText)){
        return 1;
    }
    return 2;
}
function ValidatePanNumberFields(text){
    let testText=/^[0-9]{13,13}$/
    if(text.match(testText)){
        return 1;
    }
    return 2;
}

function ValidateZipCodeFields(text){
    let testText=/^[0-9]{6,6}$/
    if(text.match(testText)){
        return 1;
    }
    return 2;
}

function ValidatePicFormats(file){
    let testText=/\.[png|jpg|jpeg|pdf]$/i
    if(file.match(testText)&&((parseFloat(file.file[0].size/1024).toFixed(2))<=1)){
        return 1;
    }
    return 2;
}

function ValidatePasswordFields(text){
    let testText=/[a-zA-Z0-9]{8,}/
    if(testText.test(text)){
        return 1;
    }return 2;
}

export { ValidatePasswordFields,ValidatePanNumberFields,ValidationResult, ValidateTextFields, ValidatePhoneNumberFields, ValidatePicFormats, ValidateZipCodeFields, ValidateAadharNumberFields};
