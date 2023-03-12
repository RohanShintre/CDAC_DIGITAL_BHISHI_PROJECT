package rest.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rest.entity.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.entity.Customer;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {


    @Transactional //Causes to start the transaction when the execution begins and end when it ends
    @Modifying //Mandatory in order to support any DML operation
    @Query("update Admin a set a.firstName = :firstName, a.middleName = :middleName, a.lastName = :lastName, a.mobileNumber = :mobileNumber, a.alternateNumber = :alternateNumber, a.aadharNumber = :aadharNumber, a.aadharPic = :aadharPic, a.panNumber = :panNumber, a.panPic = :panPic where a.adminId = :adminId")
    void updateOneAdmin(Integer adminId, String firstName, String middleName, String lastName, String mobileNumber, String alternateNumber, String aadharNumber, String aadharPic, String panNumber, String panPic);


    @Query("SELECT a FROM Admin a WHERE a.mobileNumber = :mobileNo")
    Admin findByMobileNumber(String mobileNo);

    @Modifying
    @Query("UPDATE Admin a SET a.password = :password WHERE a.mobileNumber = :mobileNumber")
    void updatePasswordByMobileNumber(String mobileNumber, String password);

    @Query("SELECT a.adminId FROM Admin a WHERE a.mobileNumber = :mobileNumber")
    Integer findAdminIdByMobileNumber( String mobileNumber);

}


