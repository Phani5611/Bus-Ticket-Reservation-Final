package com.bus.BusReservation.service;

import com.bus.BusReservation.model.Passenger;
import com.bus.BusReservation.repository.BusRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceRegister {

    // Object of the repository layer
    @Autowired
    private BusRegistrationRepo repo;


    // Registration will be successful upon unique username and email else it will be not saved in db
    public String register(Passenger passenger){

        if (repo.existsById(passenger.getUsername()) && repo.existsByEmail(passenger.getEmail())){
          return "username & email  id already exsits";
        }
            repo.save(passenger);
            return "Passenger Registered Successfully";
    }


    // getting the user data from data base
    public List<Passenger> getPassengerDetails() {
        return repo.findAll();
    }

    //Getting the user from db based on Primary key
    public Optional<Passenger> getPassengerByUsername(String username) {
        return repo.findById(username);
    }

//    public List<Passenger> getPassengerByName(Passenger passenger) {
//        return repo.findByName(passenger.getName());
//    }
}
