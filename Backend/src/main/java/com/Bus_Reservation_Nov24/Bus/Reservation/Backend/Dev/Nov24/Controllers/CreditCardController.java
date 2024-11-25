package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Controllers;


import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.APIResponse.ApiResponse;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.BookingDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.CreditCardDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service.ServiceCreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CreditCardController {


    @Autowired
    private CreditCardDetails ccdetails;

    @Autowired
    private ServiceCreditCard service;

    @Autowired
    private BookingDetails details;

    // Fetch Credit Card Payment Details
    @GetMapping("/creditcardpayment/{bookingId}")
    public ResponseEntity<CreditCardDetails> getCreditCardDetails(@PathVariable long bookingId){
        return service.getCreditCardDetails(bookingId)
                .map(details -> new ResponseEntity<>(details, HttpStatus.OK)) // Found
                .orElseGet(() -> new ResponseEntity<>(null,HttpStatus.NOT_FOUND)); // Not found
    }

    // Post mapper for saving credit card details
    @PostMapping("/creditcardpayment")
    public ResponseEntity<ApiResponse> setCreditCardDetails(@RequestBody CreditCardDetails ccdetails) {
        ApiResponse responseCreditCard = service.setCreditCardDetails(ccdetails);
        return new ResponseEntity<>(responseCreditCard, HttpStatus.valueOf(responseCreditCard.getStatusCode()));
    }

}
