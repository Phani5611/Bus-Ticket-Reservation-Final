package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service;

import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.CreditCardDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository.CreditCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.rmi.server.ExportException;
import java.util.Optional;

@Service
public class ServiceCreditCard {

    @Autowired
    private CreditCardRepo repo;



    public Optional<CreditCardDetails> getCreditCardDetails(long bookingId) {
       return repo.findById(bookingId);
    }

    public ResponseEntity<Void> setCreditCardDetails(CreditCardDetails ccdetails) {
        ccdetails.setCard_number(ccdetails.getCard_number());
        ccdetails.setCvv(ccdetails.getCvv());
        repo.save(ccdetails);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
