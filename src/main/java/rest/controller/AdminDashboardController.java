package rest.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.entity.*;
import rest.service.AdminService;
import rest.service.CustomerService;
import rest.service.NewCustomerService;

import javax.swing.text.Document;
import java.util.List;

@RestController
public class AdminDashboardController {

    @Autowired
    AdminService adminService;

    @Autowired
    CustomerService customerService;

    @Autowired
    NewCustomerService newCustomerService;

    @GetMapping("/AdminDashboard-getProfile")
    public Admin getProfile(HttpSession session) {
        boolean adminLogin = (boolean) session.getAttribute("adminLogin");
        if(! adminLogin)
            return null;
        String mobileNumber = (String) session.getAttribute("mobileNumber");
        Admin admin = adminService.getOneAdmin(mobileNumber);
        return  admin;
    }

    @GetMapping("/AdminDashboard-getAllCustomers")
    public List<Customer> getAllCustomers(HttpSession session) {
        boolean adminLogin = (boolean) session.getAttribute("adminLogin");
        if(! adminLogin)
            return null;
        String mobileNumber = (String) session.getAttribute("adminMobileNo");
        Integer adminId = Integer.valueOf(adminService.getAdminIdByMobileNumber(mobileNumber));
        List<Customer> customers = adminService.getAllCustomersForAdmin(adminId);
        return  customers;
    }

    @GetMapping("/AdminDashboard-getAllNewCustomers")
    public List<NewCustomer> getAllNewCustomers(HttpSession session) {
        boolean adminLogin = (boolean) session.getAttribute("adminLogin");
        if(! adminLogin)
            return null;
        List<NewCustomer> newCustomers = newCustomerService.getAllNewCustomer();
        return  newCustomers;
    }

    @PostMapping("/AdminDashboard-approveCustomer/{newCustomerId}")
    public boolean approveCustomer(HttpSession session, @PathVariable("newCustomerId") Integer newCustomerId, @RequestBody Bhishi bhishi) {
        boolean adminLogin = (boolean) session.getAttribute("adminLogin");
        if(! adminLogin)
            return false;
        NewCustomer newCustomer = newCustomerService.getOneNewCustomer(newCustomerId);
        if(newCustomer == null)
            return false;
        String adminMobileNumber = (String) session.getAttribute("adminMobileNo");
        Admin admin = adminService.getOneAdmin(adminMobileNumber);
        String firstName = newCustomer.getFirstName();
        String middleName = newCustomer.getMiddleName();
        String lastName = newCustomer.getLastName();
        String mobileNumber = newCustomer.getMobileNumber();
        String alternatNumber = newCustomer.getAadharNumber();
        String aadharNumber = newCustomer.getAadharNumber();
        String aadharPic = newCustomer.getAadharPic();
        String gurantor1Aadhar = newCustomer.getGuarantor1Aadhar();
        String gurantor2Aahar = newCustomer.getGuarantor2Aadhar();
        String password = newCustomer.getPassword();
        Address address = newCustomer.getNewCustomerAddress();
        Customer customer = new Customer(firstName, middleName, lastName, mobileNumber, alternatNumber, aadharNumber ,aadharPic, gurantor1Aadhar, gurantor2Aahar, password,
                address, admin, bhishi, new SecurityDocuments());
        customerService.createCustomer(customer);
        newCustomerService.deleteOneNewCustomer(newCustomerId);
        return  true;
    }


    @GetMapping("AdminDashboard-getCustomer")
    public Customer getCustomer(HttpSession session, String mobileNo){
        boolean adminLogin = (boolean) session.getAttribute("adminLogin");
        if(! adminLogin)
            return null;
        Customer customer = customerService.getOneCustomer(mobileNo);
        return customer;
    }
    @PutMapping("AdminDashboard-updateCustomer")
    public boolean updateCustomer(HttpSession session, @RequestBody Customer customer) {
        boolean adminLogin = (boolean) session.getAttribute("adminLogin");
        if(! adminLogin)
            return false;
        Customer customer1 = customerService.getOneCustomer(customer.getCustomerId());
        if(customer1 == null)
            return false;
        customerService.updateOneCustomer(customer);
        return true;

    }





}
