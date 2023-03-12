package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.entity.NewCustomer;
import rest.repository.NewCustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NewCustomerService {
    @Autowired
    private NewCustomerRepository newCustomerRepository;

    public List<NewCustomer> getAllNewCustomer(){
        List<NewCustomer> allNewCustomer = newCustomerRepository.findAll();
        return allNewCustomer;
    }

    public NewCustomer getOneNewCustomer(Integer newCustomerId) {
        Optional<NewCustomer> newCustomerOpt = newCustomerRepository.findById(newCustomerId);
        NewCustomer foundNewCustomer = newCustomerOpt.get();
        return foundNewCustomer;
    }

    public NewCustomer createNewCustomer(NewCustomer NewCustomer) {
        NewCustomer createdNewCustomer = newCustomerRepository.save(NewCustomer);
        return createdNewCustomer;
    }

    public void deleteOneNewCustomer(Integer NewCustomerId) {
        newCustomerRepository.deleteById(NewCustomerId);
    }


}
