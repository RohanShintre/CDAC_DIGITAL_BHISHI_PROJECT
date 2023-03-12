package rest.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rest.entity.SecurityDocuments;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface SecurityDocumentsRepository extends JpaRepository<SecurityDocuments, Integer> {
//    @Transactional //Causes to start the transaction when the execution begins and end when it ends
//    @Modifying //Mandatory in order to support any DML operation
//    @Query("update SecurityDocuments s set s.documentId = :documentId, s.document1 = :document1, s.document2 = :document2, s.document3 = :document3, s.document4 =:document4, where s.documentId = :documentId")
//    void updateOneAdminDetails(Integer documentId, String document1, String document2, String document3, String document4);
}
