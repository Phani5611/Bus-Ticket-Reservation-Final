package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Controllers;


import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.BookingDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.CreditCardDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service.ServiceCreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class CreditCardController {


    @Autowired
    private CreditCardDetails ccdetails;

    @Autowired
    private ServiceCreditCard service;

    @Autowired
    private BookingDetails details;

    @GetMapping("creditcardpayment/{bookingId}")
    public Optional<CreditCardDetails> getCreditCardDetails(@PathVariable long bookingId){
        return service.getCreditCardDetails(bookingId);
    }

    @PostMapping("creditcardpayment")
    public CreditCardDetails setCreditCardDetails( @RequestBody CreditCardDetails ccdetails) {
        CreditCardDetails savedCardDetails = service.setCreditCardDetails(ccdetails);
        System.out.println("Credit Card Details Saved Successfully");
        return savedCardDetails;
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
