package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service;


import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.Users;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository.UserRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRegister {

    // Object of the repository layer
    @Autowired
    private UserRegistrationRepo repo;

   public Users getUserDetails(String username){
       return repo.findByUsername(username);
   }

   public Users setUserDetails(Users user){
       Users savedUser = repo.save(user);
       return  savedUser;
   }
}
