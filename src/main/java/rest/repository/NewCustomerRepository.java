package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.entity.NewCustomer;

@Repository
public interface NewCustomerRepository extends JpaRepository<NewCustomer, Integer> {

}
