package com.bus.BusReservation.repository;

import com.bus.BusReservation.model.DebitCardDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebitCardRepo extends JpaRepository<DebitCardDetails,Integer> {

}
