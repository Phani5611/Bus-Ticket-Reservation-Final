package com.bus.model;

import com.bus.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;


//Class contains Users -> Username and Password which refers to DB
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String name;
    private String email;
    private String password;
    private String cpassword;
    private LocalDateTime createdAt;
    private Role role;

}
