package rest.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rest.entity.Admin;
import rest.entity.Customer;
import rest.otp.Otp;
import rest.otp.SendOtpPost;
import rest.pojo.Format;
import rest.pojo.Login;
import rest.service.CustomerService;

import java.util.List;



@RestController
public class CustomerLoginController {
    @Autowired
    private CustomerService customerService;



    @PostMapping("/customerLogin-generateOtp")
    public boolean generateOtp(HttpSession session, @RequestBody String mobileNumber) {
        mobileNumber = Format.formatNumber(mobileNumber);
        Otp otp = new Otp();
        String otpMessage = otp.generateOtp(4);
        System.out.println("Generated otp: " + otpMessage+" number: "+mobileNumber);
        String apiKey = "Rr36ehDsQwlLx4G925FvcXnNbmWZSPHa1pfT8OygYEIzVCMU0k98YW1XVdDhUmctBTvspouFOgr6QkCN";
        try {
            SendOtpPost.sendOtp(otpMessage, mobileNumber, apiKey);
            session.setAttribute("customerLoginOtp", otpMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/customerLogin-verifyOtp")
    public boolean loginVerifyOtp(HttpSession session, @RequestBody String otp) {
        otp = Format.formatOtp(otp);
        System.out.println("SendOtp" + otp);
        String generatedOtp =  (String) session.getAttribute("customerLoginOtp");
        if(otp.equals(generatedOtp)){
            System.out.println("Verified");
            session.setAttribute("customerLoginOtpVerified",true);
            return true;
        }
        else{
            System.out.println("Noooooo");
            session.setAttribute("customerLoginOtpVerified",false);
            return false;
        }

    }



    //0 - MobileNo is not registerd
    //1 - Password is incorrect
    //2- success
    @PostMapping("/customerLogin-login")
    public boolean login(HttpSession session, @RequestBody Login login) {
        if(! (boolean) session.getAttribute("customerLoginOtpVerified")) {
            return false;
        }

        String mobileNo = login.getMobileNo();
        String password = login.getPassword();
        List<Customer> customers = customerService.getAllCustomer();
        for(Customer customer: customers) {
            if(mobileNo.equals(customer.getMobileNumber())) {
                if(!password.equals(customer.getPassword())) {
                    System.out.println("mobileNo"+ mobileNo);
                    System.out.println("Password"+ password);
                    //System.out.println("mobileNo"+ mobileNo);
                    System.out.println("Password"+ customer.getPassword());
                    return false;
                }
                session.setAttribute("customerLogin", true);
                session.setAttribute("customerMobileNo", mobileNo);
                return true;
            }
        }
        return false;
    }

    //0 mobileNo is not registerd;
    //1 otp generated Successfully
    //2 otp generation failed
    @PostMapping("/CustomerLogin-forgetPassword")
    public boolean forgetPassword(HttpSession session, @RequestBody  String mobileNumber){
        mobileNumber = Format.formatNumber(mobileNumber);
        Customer customer = customerService.getOneCustomer(mobileNumber);
        if(customer == null)
            return false;
        session.setAttribute("customerMobileNumber", mobileNumber);
        Otp otp = new Otp();
        String otpMessage = otp.generateOtp(4);
        //System.out.println("Generated otp: " + otpMessage);
        String apiKey = "Rr36ehDsQwlLx4G925FvcXnNbmWZSPHa1pfT8OygYEIzVCMU0k98YW1XVdDhUmctBTvspouFOgr6QkCN";
        try {
            SendOtpPost.sendOtp(otpMessage, mobileNumber, apiKey);
            session.setAttribute("forgetPasswordOtp", otpMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/customerLogin-forgetPassword-verifyOtp")
    public boolean verifyOtp(HttpSession session, String Otp) {
        Otp = Format.formatOtp(Otp);
        String forgetPasswordOtp =  (String) session.getAttribute("forgetPasswordOtp");
        System.out.println("SendOtp" + Otp);
        if(Otp.equals(forgetPasswordOtp)){
            System.out.println("Verified");
            session.setAttribute("forgetPasswordOtpVerified",true);
            return true;
        }
        else{
            System.out.println("Noooooo");
            session.setAttribute("forgetPasswordOtpVerified",false);
            return false;
        }
    }

    @PostMapping("customerLogin-resetPassword")
    public boolean resetPassword(HttpSession session, @RequestBody String password) {
        boolean otpVerified = (boolean) session.getAttribute("forgetPasswordOtpVerified");
        if(!otpVerified)
            return false;
        String mobileNumber = (String) session.getAttribute("customerMobileNumber");
        customerService.updatePassword(mobileNumber, password);
        return true;
    }

}
