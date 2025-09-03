package com.bus.controllers;


import com.bus.apiresponse.ApiResponse;
import com.bus.model.BookingDetails;
import com.bus.model.CreditCardDetails;
import com.bus.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreditCardController {


    @Autowired
    private CreditCardDetails ccdetails;

    @Autowired
    private CreditCardService service;

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
