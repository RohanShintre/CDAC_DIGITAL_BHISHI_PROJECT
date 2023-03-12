package rest.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rest.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Transactional //Causes to start the transaction when the execution begins and end when it ends
    @Modifying //Mandatory in order to support any DML operation
    @Query("update Customer c set c.firstName = :firstName, c.middleName = :middleName, c.lastName = :lastName, c.mobileNumber = :mobileNumber, c.alternateNumber = :alternateNumber, c.aadharNumber = :aadharNumber, c.aadharPic = :aadharPic, c.guarantor1Aadhar = :guarantor1Aadhar, c.guarantor2Aadhar = :guarantor2Aadhar where c.customerId = :customerId")
    void updateOneCustomer(Integer customerId, String firstName, String middleName, String lastName, String mobileNumber, String alternateNumber, String aadharNumber, String aadharPic, String guarantor1Aadhar, String guarantor2Aadhar);

    @Query("SELECT c FROM Customer c WHERE c.mobileNumber = :mobileNo")
    Customer findByMobileNumber(@Param("mobileNo") String mobileNo);

    @Modifying
    @Query("UPDATE Customer c SET c.password = :password WHERE c.mobileNumber = :mobileNumber")
    void updatePasswordByMobileNumber(@Param("mobileNumber") String mobileNumber, @Param("password") String password);

    @Query("SELECT c FROM Customer c WHERE c.admin.id = :adminId")
    List<Customer> findByAdminId(@Param("adminId") Integer adminId);
}
