package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Config;

import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@Configuration
//Breaks the default security filter chain
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    MyUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);  // Strength of the hash (12 is recommended)
    }


    //We are customizing the secuirty flow by breaking the default filter chain and implementing our owun logic
    //HTTPSecurity returns the object of SecurityFilterChain


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().authorizeHttpRequests().requestMatchers("/login","/booking","/booking/{bookingId}","/register","/creditcardpayment","/debitcardpayment","creditcardpayment/{bookingId}","cancel/{bookingId}","/css/**", "/js/**").permitAll().anyRequest().authenticated();
        //http.formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/home",true);
        //http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.formLogin().disable();
        http.httpBasic().disable();
        http.csrf().disable();
       return http.build();
    }


//    //Default Login Page by Spring Security
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         return http
//                .csrf(customizer->customizer.disable())
//                 //.authorizeHttpRequests().antMatchers("/login", "/css/**", "/js/**").permitAll().anyRequest().authenticated()
//                 //Security is applied and access is denied without password and username
//                 .authorizeHttpRequests(request->request.anyRequest().authenticated())
//
//                //Enable the form login
//                .formLogin(Customizer.withDefaults())
//
//                //For REST Data access
//                //This also gives an ALERT BOX if you disable the formLogin
//                 .httpBasic(Customizer.withDefaults())
//
//                //Making HTTP stateless(Everytime a new session id is generated ) because we are disabling the CSRF Token
//                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//
//                //Return the SecurityFilterChain Object
//                .build();
//
//    }

        //For making users authenicated from DB we use custom Authenication Provider Filter instead of Default Auth Provider
        @Bean
        public AuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
            authenticationProvider.setPasswordEncoder(passwordEncoder());
            authenticationProvider.setUserDetailsService(userDetailsService);
            return authenticationProvider;
        }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("http://127.0.0.1:5500"));  // Allow your frontend origin
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);  // Apply CORS to all paths
        return source;
    }


}
