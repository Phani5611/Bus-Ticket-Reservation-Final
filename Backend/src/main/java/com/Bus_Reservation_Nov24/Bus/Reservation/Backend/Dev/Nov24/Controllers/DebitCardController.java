package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Controllers;


import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.DebitCardDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service.ServiceDebitCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class DebitCardController {


        @Autowired
        private ServiceDebitCard service;

        @GetMapping("/debitcardpayment/{bookingId}")
        public Optional<DebitCardDetails> getDebitCardDetails(@PathVariable long bookingId){
            return service.getDebitCardDetails(bookingId);
        }

        @PostMapping("/debitcardpayment")
        public DebitCardDetails setDebitCardDetails(@RequestBody DebitCardDetails dcdetails){
          DebitCardDetails savedDebitCardDetails =  service.setDebitCardDetails(dcdetails);
            System.out.println("Debit Card Details Saved Successfully");
            return savedDebitCardDetails;
        }
}
