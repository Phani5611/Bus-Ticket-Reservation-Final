package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Controllers;



import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.APIResponse.ApiStatusResponse;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.Users;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service.ServiceRegister;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserRegistrationController {

    @Autowired
    private ServiceRegister service;


    //Gets the passengers details present in db
    @GetMapping("register/{username}")
    public Users getUserDetails(@PathVariable String username){
        return  service.getUserDetails(username);

    }


    //Post Mapper for Registration  - Registers / Save's the unique data
    @PostMapping("register")
    public ResponseEntity<ApiStatusResponse> register(@RequestBody Users user){
           ApiStatusResponse responseRegister = service.setUserDetails(user);
           return  new ResponseEntity<>(responseRegister,HttpStatusCode.valueOf(responseRegister.getStatusCode()));



}

}
