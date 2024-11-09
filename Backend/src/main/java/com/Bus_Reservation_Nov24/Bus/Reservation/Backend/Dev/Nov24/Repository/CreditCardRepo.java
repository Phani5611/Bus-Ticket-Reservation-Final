package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository;


import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.CreditCardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepo extends JpaRepository<CreditCardDetails,Long> {

}
