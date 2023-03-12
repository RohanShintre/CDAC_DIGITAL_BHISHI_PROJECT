package rest.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.entity.Admin;
import rest.otp.Otp;
import rest.otp.SendOtpPost;
import rest.pojo.Format;
import rest.service.AdminService;

import java.util.List;

@RestController
public class AdminRegistrationController {

    @Autowired
    private AdminService adminService;
    @GetMapping("/adminRegistration-generateOtp/{mobileNumber}")
    public boolean generateOtp(HttpSession session, @PathVariable("mobileNumber") String mobileNumber) {
        List<Admin> admins = adminService.getAllAdmin();
        for (Admin iterator: admins) {
            if(iterator.getMobileNumber().equals(mobileNumber)) {
                System.out.println("mobile number is already Present");
                return  false;
            }
        }
        Otp otp = new Otp();
        String otpMessage = otp.generateOtp(4);
        //System.out.println("Generated otp: " + otpMessage);
        String apiKey = "Rr36ehDsQwlLx4G925FvcXnNbmWZSPHa1pfT8OygYEIzVCMU0k98YW1XVdDhUmctBTvspouFOgr6QkCN";
        try {
            SendOtpPost.sendOtp(otpMessage, mobileNumber, apiKey);
            session.setAttribute("adminOtp", otpMessage);
            return true;
        } catch (Exception e){
            return false;
        }
    }


    @PostMapping("/adminRegistration-verifyOtp")
    public boolean verifyOtp(HttpSession session, @RequestBody String otp) {
        otp = Format.formatOtp(otp);

        String generatedOtp =  (String) session.getAttribute("adminOtp");
        if(otp.equals(generatedOtp)){
            System.out.println("Verified");
            session.setAttribute("adminOtpVerified",true);
            return true;
        }
        else{
            System.out.println("Noooooo");
            session.setAttribute("adminOtpVerified",false);
            return false;
        }

    }




    @PostMapping("/adminRegistration-register")
    public boolean registerAdmin(HttpSession session, @RequestBody Admin admin){
        if(session.getAttribute("adminOtpVerified") == null) {
            System.out.println("Otp is not verified");
            return false;
        }
        boolean verified = (boolean) session.getAttribute("adminOtpVerified");
        if(verified){

            // will do this verification later on
//            List<Admins> admin = adminService.getAllAdmins();
//            for (Admins iterator: admin) {
//                if(iterator.getAadharNumber().equals(admin.getAadharNumber()) {
//                    System.out.println("Customer number is already Present");
//                    return;
//                }
//            }
            adminService.createAdmin(admin);
            System.out.println("New Customer inserted successfully");
            return true;
        }
        else {
            System.out.println("Otp is not verified");
            return false;
        }
    }
//
//    @RequestMapping(..)
//    public String someControllerMethod(HttpSession session) {
//        session.setAttribute(Constants.CART, new Cart());
//    ...
//        Cart cart = (Cart) session.getAttribute(Constants.CART);
//    }
}
