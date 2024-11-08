package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service;

import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.CreditCardDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository.CreditCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCreditCard {

    @Autowired
    private CreditCardRepo repo;


    public List<CreditCardDetails> getCreditCardDetails() {

        return repo.findAll();
    }

    public CreditCardDetails setCreditCardDetails(CreditCardDetails ccdetails) {

         repo.save(ccdetails);
         return  ccdetails;
    }
}
