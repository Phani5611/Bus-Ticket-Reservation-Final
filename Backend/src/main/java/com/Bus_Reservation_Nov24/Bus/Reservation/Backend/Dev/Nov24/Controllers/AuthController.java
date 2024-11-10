package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Controllers;

import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.LoginRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")  // Allow requests from frontend
public class AuthController {

    @Autowired
    private AuthenticationProvider authenticationProvider;

     @PostMapping("greet2")
     public String greet2(){
         return "Hi in login controller";
     }


    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody LoginRequest loginRequest, HttpSession session) {
        try {
            // Create authentication token with username and password
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());

            // Authenticate the token using AuthenticationProvider
            Authentication authentication = authenticationProvider.authenticate(authenticationToken);

            // If authentication is successful, set the Authentication in the SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Return success response
            return ResponseEntity.ok().body("{\"success\": true}");
        } catch (Exception e) {
            // If authentication fails, return an error response
            return ResponseEntity.status(401).body("{\"error\": \"Invalid username or password\"}");
        }
    }
}
