package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service;

import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.User;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository.UserRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginAuthService {

    @Autowired
    private UserRegistrationRepo repo;

    public boolean authenticate(String username, String password){
        User user  = repo.findByUsername(username);
        if(user!=null && user.getPassword().equals(password)){
            return true;
        }
        else{
            return  false;
        }
    }
}
