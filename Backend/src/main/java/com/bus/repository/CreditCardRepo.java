package com.bus.repository;


import com.bus.model.CreditCardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepo extends JpaRepository<CreditCardDetails,Long> {

}
