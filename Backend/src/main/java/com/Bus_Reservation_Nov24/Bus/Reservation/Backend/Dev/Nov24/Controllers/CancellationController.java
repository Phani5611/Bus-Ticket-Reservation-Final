package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Controllers;

import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.APIResponse.ApiResponse;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service.ServiceBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CancellationController {

    @Autowired
    private ServiceBooking service;

    @DeleteMapping("/cancel/{bookingId}")
    public ResponseEntity<ApiResponse> cancel(@PathVariable long bookingId){
       ApiResponse responseCancel = service.cancelTicket(bookingId);
       return new ResponseEntity<>(responseCancel, HttpStatusCode.valueOf(responseCancel.getStatusCode()));
    }
}


