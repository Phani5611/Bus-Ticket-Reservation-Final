package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service;


import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.Passenger;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository.BusRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceRegister {

    // Object of the repository layer
    @Autowired
    private BusRegistrationRepo repo;

   @GetMapping("/register")
   public List<Passenger> getPassengerDetails(){
       return  repo.findAll();
   }


   @PostMapping("/register")
    public Passenger setPassengerDetails(Passenger passenger) {
      repo.save(passenger);
      return passenger;


    }

}
