package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.entity.Customer;
import rest.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer(){
        List<Customer> allCustomer = customerRepository.findAll();
        return allCustomer;
    }

    public Customer getOneCustomer(Integer customerId) {
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        Customer foundCustomer = customerOpt.get();
        return foundCustomer;
    }

    public Customer getOneCustomer(String mobileNo) {
        Optional<Customer> customerOpt = Optional.ofNullable(customerRepository.findByMobileNumber(mobileNo));
        Customer foundCustomer = customerOpt.get();
        return foundCustomer;
    }

    public Customer createCustomer(Customer Customer) {
        Customer createdCustomer = customerRepository.save(Customer);
        return createdCustomer;
    }

    public void deleteOneCustomer(Integer CustomerId) {
        customerRepository.deleteById(CustomerId);
    }

    public void updateOneCustomer(Customer customer) {
        Integer customerId = customer.getCustomerId();
        String firstName = customer.getFirstName();
        String middleName = customer.getMiddleName();
        String lastName = customer.getLastName();
        String mobileNumber = customer.getMobileNumber();
        String alternateNumber = customer.getAlternateNumber();
        String aadharNumber = customer.getAadharNumber();
        String aadharPic = customer.getAadharPic();
        String guarantor1Aadhar = customer.getGuarantor1Aadhar();
        String guarantor2Aadhar = customer.getGuarantor2Aadhar();
        customerRepository.updateOneCustomer(customerId, firstName, middleName, lastName, mobileNumber, alternateNumber, aadharNumber, aadharPic, guarantor1Aadhar, guarantor2Aadhar);
    }

    public void updatePassword(String mobileNumber, String password) {
        customerRepository.updatePasswordByMobileNumber(mobileNumber, password);
    }

}
