package com.bus.repository;


import com.bus.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepo extends JpaRepository<Users,String> {

    Users findByUsername(String username);

    Users findByEmail(String email);
}
