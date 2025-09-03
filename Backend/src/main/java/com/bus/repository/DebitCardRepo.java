package com.bus.repository;

import com.bus.model.DebitCardDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebitCardRepo extends JpaRepository<DebitCardDetails,Long> {

}
