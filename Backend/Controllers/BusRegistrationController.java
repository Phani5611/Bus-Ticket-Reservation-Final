package com.bus.BusReservation.controllers;


import com.bus.BusReservation.model.Passenger;
import com.bus.BusReservation.service.ServiceRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class BusRegistrationController {

    @Autowired
    private ServiceRegister service;

    // Gets the data based on username
    @GetMapping("register/{username}")
    public Optional<Passenger> getPassengerByUsername( @PathVariable String username)
    {
        return  service.getPassengerByUsername(username);
    }

    //Gets the 'ALL' passengers details present in db
    @GetMapping("register")
    public List<Passenger> getPassengerDetails()
    {
        return  service.getPassengerDetails();

    }


    //Registers / Save's the unique data based on the username into the db
    @PostMapping("register")
    public void register(@RequestBody Passenger passenger ){
        System.out.println(service.register(passenger));
}

}
