package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service;

import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.CreditCardDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.DebitCardDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository.DebitCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDebitCard {

    @Autowired
    private DebitCardRepo repo;

    @Autowired
    private DebitCardDetails dcdetails;

    public Optional<DebitCardDetails> getDebitCardDetails(long bookingId) {
       return repo.findById(bookingId);
    }

    public ResponseEntity<Void> setDebitCardDetails(DebitCardDetails dcdetails) {
        dcdetails.setCard_number(dcdetails.getCard_number());
        dcdetails.setCvv(dcdetails.getCvv());
        repo.save(dcdetails);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
