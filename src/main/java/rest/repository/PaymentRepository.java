package rest.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rest.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {


    @Transactional
    @Modifying
    @Query("UPDATE Payment p SET p.status = :status WHERE p.referenceId = :referenceId")
    void updatePaymentStatus(@Param("referenceId") String referenceId, @Param("status") boolean status);

    @Query("SELECT MAX(p.referenceId) FROM Payment p")
    String findMaxReferenceId();


}
