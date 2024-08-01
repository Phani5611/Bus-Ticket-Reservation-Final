package com.bus.BusReservation.service;

import com.bus.BusReservation.model.CreditCardDetails;
import com.bus.BusReservation.repository.CreditCardRepo;
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

    public void setCreditCardDetails(CreditCardDetails ccdetails) {
        repo.save(ccdetails);
    }
}
