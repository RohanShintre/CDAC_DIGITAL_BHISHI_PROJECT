package rest.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rest.entity.Admin;
import rest.otp.Otp;
import rest.otp.SendOtpPost;
import rest.pojo.Format;
import rest.pojo.Login;
import rest.service.AdminService;

import java.util.List;

@RestController
public class AdminLoginController {
    @Autowired
    private AdminService adminService;




    @PostMapping("/adminLogin-generateOtp")
    public boolean generateOtp(HttpSession session, @RequestBody String mobileNumber) {
        mobileNumber = Format.formatNumber(mobileNumber);
        Otp otp = new Otp();
        String otpMessage = otp.generateOtp(4);
        System.out.println("Generated otp: " + otpMessage);
        String apiKey = "Rr36ehDsQwlLx4G925FvcXnNbmWZSPHa1pfT8OygYEIzVCMU0k98YW1XVdDhUmctBTvspouFOgr6QkCN";
        try {
            SendOtpPost.sendOtp(otpMessage, mobileNumber, apiKey);
            session.setAttribute("adminLoginOtp", otpMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/adminLogin-verifyOtp")
    public boolean loginVerifyOtp(HttpSession session, @RequestBody String otp) {
        otp = Format.formatOtp(otp);
        System.out.println(otp);
        String generatedOtp =  (String) session.getAttribute("adminLoginOtp");
        if(otp.equals(generatedOtp)){
            System.out.println("Verified");
            session.setAttribute("adminLoginOtpVerified",true);
            return true;
        }
        else{
            System.out.println("Noooooo");
            session.setAttribute("adminLoginOtpVerified",false);
            return false;
        }

    }


    //0 - Otp is not verfied
    //1 - Password is incorrect
    //
    @PostMapping("/adminLogin-login")
    public boolean login(HttpSession session, @RequestBody Login login) {
        if(!(Boolean) session.getAttribute("adminLoginOtpVerified")){
            return false;
        }
        String mobileNo = login.getMobileNo();
        String password = login.getPassword();
        List<Admin> admins = adminService.getAllAdmin();
        for(Admin admin: admins) {
            if(mobileNo.equals(admin.getMobileNumber())) {
                if(! password.equals(admin.getPassword()))
                    return false;
                session.setAttribute("adminLogin", true);
                session.setAttribute("adminMobileNo", mobileNo);
                return true;
            }
        }
        System.out.println("xxxxxxxxxxxxx");
        return false;
    }

    //0 mobileNo is not registerd;
    //1 otp generated Successfully
    //2 otp generation failed
    @PostMapping("/adminLogin-forgetPassword")
    public boolean forgetPassword(HttpSession session,@RequestBody String mobileNumber){
        mobileNumber = Format.formatNumber(mobileNumber);
        Admin admin = adminService.getOneAdmin(mobileNumber);
        if(admin == null)
            return false;
        session.setAttribute("adminMobileNumber", mobileNumber);
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

    @PostMapping("/adminLogin-forgetPassword-verifyOtp")
    public boolean verifyOtp(HttpSession session, String Otp) {
        Otp = Format.formatOtp(Otp);
        String forgetPasswordOtp =  (String) session.getAttribute("forgetPasswordOtp");
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

    @PostMapping("adminLogin-resetPassword")
    public boolean resetPassword(HttpSession session, String password) {
        boolean otpVerified = (boolean) session.getAttribute("forgetPasswordOtpVerified");
        if(!otpVerified)
            return false;
        String mobileNumber = (String) session.getAttribute("adminMobileNumber");
        adminService.updatePassword(mobileNumber, password);
        return true;
    }


}
