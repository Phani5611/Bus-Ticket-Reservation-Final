package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service;


import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.Users;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository.UserRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServiceRegister {

    // Object of the repository layer
    @Autowired
    private UserRegistrationRepo repo;

    @Autowired
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

   public Users getUserDetails(String username){
       return repo.findByUsername(username);
   }

   public ResponseEntity<Void> setUserDetails(Users user){
       try{
           Users existingUser = repo.findByUsername(user.getUsername());
           Users existingEmail = repo.findByEmail(user.getEmail());
           if (existingUser != null && existingEmail!=null) {
               // User already exists, return a conflict response
               return ResponseEntity.status(HttpStatus.CONFLICT).build();
           }
           else if(existingEmail !=null){
               return  ResponseEntity.status(HttpStatus.CONFLICT).build();
           }

       }
       catch (Exception e){
           System.out.println("Exception -"+e);
       }
       user.setPassword(encoder.encode(user.getPassword()));
       user.setCpassword(encoder.encode(user.getCpassword()));
       repo.save(user);
       return ResponseEntity.status(HttpStatus.CREATED).build();
   }
}
