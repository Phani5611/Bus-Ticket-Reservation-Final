package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Controllers;


import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.DebitCardDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service.ServiceDebitCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class DebitCardController {


        @Autowired
        private ServiceDebitCard service;

        @GetMapping("debitcardpayment")
        public List<DebitCardDetails> getDebitCardDetails(){
            
            return service.getDebitCardDetails();
        }

        @PostMapping("debitcardpayment")
        public DebitCardDetails setDebitCardDetails(@RequestBody DebitCardDetails dcdetails){
          DebitCardDetails savedDebitCardDetails =  service.setDebitCardDetails(dcdetails);
            System.out.println("Debit Card Details Saved Successfully");
            return savedDebitCardDetails;
        }
}
