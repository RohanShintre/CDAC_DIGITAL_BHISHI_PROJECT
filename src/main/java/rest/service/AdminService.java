package rest.service;

import rest.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.entity.Customer;
import rest.repository.AdminRepository;
import rest.repository.CustomerRepository;


import java.util.List;
import java.util.Optional;


@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Admin> getAllAdmin(){
        List<Admin> allAdmin = adminRepository.findAll();
        return allAdmin;
    }

    public Admin getOneAdmin(Integer AdminId) {
        Optional<Admin> adminOpt = adminRepository.findById(AdminId);
        Admin foundAdmin = adminOpt.get();
        return foundAdmin;
    }

    public Admin getOneAdmin(String mobileNo) {
        Optional<Admin> adminOpt = Optional.ofNullable(adminRepository.findByMobileNumber(mobileNo));
        Admin foundAdmin = adminOpt.get();
        return foundAdmin;
    }

    public Admin createAdmin(Admin Admin) {
        Admin createdAdmin = adminRepository.save(Admin);
        return createdAdmin;
    }


    public void deleteOneAdmin(Integer AdminId) {
        adminRepository.deleteById(AdminId);
    }

    public Integer getAdminIdByMobileNumber(String mobileNumber) {
        Integer adminId = adminRepository.findAdminIdByMobileNumber(mobileNumber);
        return  adminId;
    }

    public List<Customer> getAllCustomersForAdmin(Integer adminId) {
        return customerRepository.findByAdminId(adminId);
    }

    public void updateOneAdmin(Admin admin) {
        Integer adminId = admin.getAdminId();
        String firstName = admin.getFirstName();
        String middleName = admin.getMiddleName();
        String lastName = admin.getLastName();
        String mobileNumber = admin.getMobileNumber();
        String alternateNumber = admin.getAlternateNumber();
        String aadharNumber = admin.getAadharNumber();
        String aadharPic = admin.getAadharPic();
        String panNumber = admin.getPanNumber();
        String panPic = admin.getPanPic();
        adminRepository.updateOneAdmin(adminId, firstName, middleName, lastName, mobileNumber, alternateNumber, aadharNumber, aadharPic, panNumber, panPic);
    }

    public void updatePassword(String mobileNumber, String password) {
        adminRepository.updatePasswordByMobileNumber(mobileNumber, password);
    }
}
