package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Controllers;



import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.User;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service.ServiceRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserRegistrationController {

    @Autowired
    private ServiceRegister service;


    //Gets the 'ALL' passengers details present in db
    @GetMapping("register/{username}")
    public User getUserDetails(@PathVariable String username)
    {
        return  service.getUserDetails(username);

    }


    //Registers / Save's the unique data
    @PostMapping("register")
    public User register(@RequestBody User user){
        User savedUserDetails = service.setUserDetails(user);
        System.out.println("Passenger Detials Saved Successfully");
        return savedUserDetails;
}

}
