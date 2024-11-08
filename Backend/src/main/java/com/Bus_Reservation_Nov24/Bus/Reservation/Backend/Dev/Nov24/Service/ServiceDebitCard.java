package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service;

import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.DebitCardDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository.DebitCardRepo;
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

    public DebitCardDetails setDebitCardDetails(DebitCardDetails dcdetails){

        repo.save(dcdetails);
        return dcdetails;
    }
}
