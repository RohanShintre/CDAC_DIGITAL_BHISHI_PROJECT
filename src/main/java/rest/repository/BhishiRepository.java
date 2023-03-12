package rest.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rest.entity.Bhishi;

@Repository
public interface BhishiRepository extends JpaRepository<Bhishi, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Bhishi b SET b.paidUpValues = :paidUpValues WHERE b.bhishiId = :bhishiId")
    void updatePaidUpValues(@Param("bhishiId") int bhishiId, @Param("paidUpValues") double paidUpValues);


}
