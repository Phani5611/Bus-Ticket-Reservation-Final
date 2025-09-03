package com.bus.controllers;



import com.bus.apiresponse.ApiStatusResponse;
import com.bus.model.Users;
import com.bus.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserRegistrationController {

    @Autowired
    private RegistrationService service;


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
