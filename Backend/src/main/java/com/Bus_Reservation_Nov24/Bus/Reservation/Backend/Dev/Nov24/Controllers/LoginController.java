package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Controllers;

import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.LoginRequest;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service.LoginAuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class LoginController {

    @Autowired
    private LoginAuthService loginAuthService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpSession session){
        boolean isAuthenticated = loginAuthService.authenticate(loginRequest.getUsername(),loginRequest.getPassword());
            if(isAuthenticated){
               session.setAttribute("username",loginRequest.getUsername());
                System.out.println("User Login Successful");
               return ResponseEntity.ok().body("{\"success\": true}");
            }
            else{
                System.out.println("Invalid Id and password");
                return ResponseEntity.status(401).body("{\"success\": false}");
            }

        }
    }


//    @GetMapping("/logout")
//    public String logout(HttpSession session){
//        session.invalidate();
//        return  "Logged out successfully!!";
//    }
//
//}
