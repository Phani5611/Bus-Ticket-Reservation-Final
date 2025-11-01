package com.bus.model;

import com.bus.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
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
    @Column(name = "username")
    private String username;

    @Column(name = "fist_name")
    private String firstname;
    @Column(name="last_name")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
