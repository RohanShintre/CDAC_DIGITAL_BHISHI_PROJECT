package rest.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rest.entity.SessionLogs;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface SessionLogsRepository extends JpaRepository<SessionLogs, Integer> {
//    @Transactional //Causes to start the transaction when the execution begins and end when it ends
//    @Modifying //Mandatory in order to support any DML operation
//    @Query("update SessionLogs s set s.sessionStart = :sessionStart, s.sessionEnd = :sessionEnd, s.loginId = :loginId, s.tokenId = :tokenId where l.logId = :logId")
//    void updateOneAdminDetails(Integer logId, LocalDateTime sessionStart, LocalDateTime sessionEnd, Integer loginId, Integer tokenId);

}
