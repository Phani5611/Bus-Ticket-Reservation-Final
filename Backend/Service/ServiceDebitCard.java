package com.bus.BusReservation.service;

import com.bus.BusReservation.model.DebitCardDetails;
import com.bus.BusReservation.repository.DebitCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDebitCard {

    @Autowired
    private DebitCardRepo repo;

    @Autowired
    private DebitCardDetails dcdetails;

    public List<DebitCardDetails> getDebitCardDetails() {
        return repo.findAll();
    }

    public void setDebitCardDetails(DebitCardDetails dcdetails){
        repo.save(dcdetails);
    }
}
