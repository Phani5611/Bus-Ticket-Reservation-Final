package com.bus.BusReservation.controllers;

import com.bus.BusReservation.model.BookingDetails;
import com.bus.BusReservation.model.CreditCardDetails;
import com.bus.BusReservation.service.ServiceCreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class CreditCardController {


    @Autowired
    private CreditCardDetails ccdetails;

    @Autowired
    private ServiceCreditCard service;

    @Autowired
    private BookingDetails details;

    @GetMapping("ccPayment")
    public List<CreditCardDetails> getCreditCardDetails(){
        return service.getCreditCardDetails();
    }

    @PostMapping("ccPayment")
    public String setCreditCardDetails(@RequestBody CreditCardDetails ccdetails){
        //ccdetails.setUsername(details.getName());
       service.setCreditCardDetails(ccdetails);
       return "Credit Card Details Saved Successfully";
    }

    //This code is for handling Non-JSON data

//   @PostMapping("ccPayment")
//    public ResponseEntity<String> handlePayment(
//            @RequestParam("card_number") String cardNumber,
//            @RequestParam("exp_date") String expDate,
//            @RequestParam("cvv") String cvv,
//            @RequestParam("card_owner_name") String cardOwnerName) {
        // Handle the payment logic here
//        service.setCreditCardDetails(ccdetails);
//        return ResponseEntity.ok("Payment processed");
//    }
}
