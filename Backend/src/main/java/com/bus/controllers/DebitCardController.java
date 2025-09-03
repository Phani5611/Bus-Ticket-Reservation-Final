package com.bus.controllers;


import com.bus.apiresponse.ApiResponse;
import com.bus.model.DebitCardDetails;
import com.bus.service.DebitCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class DebitCardController {


        @Autowired
        private DebitCardService service;

        // Fetch Mapper using ID - Debit Card Details
        @GetMapping("/debitcardpayment/{bookingId}")
        public ResponseEntity<Optional<DebitCardDetails>> getDebitCardDetails(@PathVariable long bookingId){
             Optional<DebitCardDetails> getDebitCardDetails = service.getDebitCardDetails(bookingId);
             if(getDebitCardDetails!=null){
                 return new ResponseEntity<>(getDebitCardDetails, HttpStatus.OK);
             }
             return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        // Post Mapper - Debit Card Details
        @PostMapping("/debitcardpayment")
        public ResponseEntity<ApiResponse> setDebitCardDetails(@RequestBody DebitCardDetails dcdetails){
          ApiResponse debitCardDetailsResponse =  service.setDebitCardDetails(dcdetails);
          return  new ResponseEntity<>(debitCardDetailsResponse, HttpStatusCode.valueOf(debitCardDetailsResponse.getStatusCode()));
        }
}
