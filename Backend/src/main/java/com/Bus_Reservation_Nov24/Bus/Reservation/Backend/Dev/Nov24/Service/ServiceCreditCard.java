package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service;

import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.CreditCardDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository.CreditCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceCreditCard {

    @Autowired
    private CreditCardRepo repo;


    public Optional<CreditCardDetails> getCreditCardDetails(long bookingId) {
       return repo.findById(bookingId);
    }

    public CreditCardDetails setCreditCardDetails(CreditCardDetails ccdetails) {
         repo.save(ccdetails);
         return  ccdetails;
    }
}
