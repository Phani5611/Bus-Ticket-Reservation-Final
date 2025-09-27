package com.bus.exceptions.globalexceptionhandler;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder({ "errorName","status", "message", "endpoint", "timestamp" })
public class ErrorResponse {
    private String ErrorName;
    private Integer status;
    private  String message;
    private String endpoint;
    private LocalDateTime timestamp;
}
