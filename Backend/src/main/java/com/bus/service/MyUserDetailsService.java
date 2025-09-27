package com.bus.service;

import com.bus.model.UserPrincipal;
import com.bus.model.Users;
import com.bus.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/*
This Service helps in getting yhe UserDetails Authentication by providing the object of UserDetails Service.
Which is required for custom Auth Provider.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRegistrationRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);

        if(user==null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User Not Found");
        }

        return new UserPrincipal(user);
    }
}
