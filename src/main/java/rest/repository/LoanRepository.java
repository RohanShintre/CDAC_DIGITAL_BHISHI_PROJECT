package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {
//    @Transactional //Causes to start the transaction when the execution begins and end when it ends
//    @Modifying //Mandatory in order to support any DML operation
//    @Query("update LoanDetails l set l.startDate = :startDate, l.endDate = :endDate, l.principleAmount = :principleAmount, l.interestPercent = :interestPercent, l.repaidAmount = :repaidAmount, where l.loanId = :loanId")
//    void updateOneAdminDetails(Integer loanId, LocalDateTime startDate, LocalDate endDate, Double principalAmount, Float interestPercent, Double repaidAmount);

}

