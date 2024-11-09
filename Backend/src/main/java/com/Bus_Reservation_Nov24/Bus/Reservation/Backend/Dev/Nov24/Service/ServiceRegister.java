package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service;


import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.User;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository.UserRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class ServiceRegister {

    // Object of the repository layer
    @Autowired
    private UserRegistrationRepo repo;

   public User getUserDetails(String username){
       return repo.findByUsername(username);
   }

   public User setUserDetails(User user){
       User savedUser = repo.save(user);
       return  savedUser;
   }
}
