package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Controllers;



import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.Users;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service.ServiceRegister;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserRegistrationController {

    @Autowired
    private ServiceRegister service;


    //Gets the 'ALL' passengers details present in db
    @GetMapping("register/{username}")
    public Users getUserDetails(@PathVariable String username)
    {
        return  service.getUserDetails(username);

    }


    //Registers / Save's the unique data
    @PostMapping("register")
    public ResponseEntity<Void> register(@RequestBody Users user){

           ResponseEntity<Void> response = service.setUserDetails(user);
            System.out.println("User creation successfull.");
            return response;



}

}
