package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Controllers;



import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.Passenger;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service.ServiceRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class BusRegistrationController {

    @Autowired
    private ServiceRegister service;


    //Gets the 'ALL' passengers details present in db
    @GetMapping("register")
    public List<Passenger> getPassengerDetails()
    {
        return  service.getPassengerDetails();

    }


    //Registers / Save's the unique data
    @PostMapping("register")
    public Passenger register(@RequestBody Passenger passenger ){
        Passenger savedPassengerDetails = service.setPassengerDetails(passenger);
        System.out.println("Passenger Detials Saved Successfully");
        return savedPassengerDetails;
}

}
