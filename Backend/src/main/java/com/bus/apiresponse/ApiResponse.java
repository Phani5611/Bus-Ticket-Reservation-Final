package com.bus.apiresponse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

//Responsible for handling the status code's, success / error messages and Booking ID  to get hold of it.
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private int statusCode;
    private String message;
    private UUID bookingId;
}
