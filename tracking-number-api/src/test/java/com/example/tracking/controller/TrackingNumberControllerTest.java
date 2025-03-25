package com.example.tracking.controller;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.tracking.entity.dto.TrackingNumberRequest;
import com.example.tracking.service.TrackingNumberService;


public class TrackingNumberControllerTest {


    TrackingNumberRequest request;
    TrackingNumberController controller;
    @InjectMocks
    TrackingNumberService service;

    @BeforeEach
    public void setUp() {
       controller = new TrackingNumberController();
      
   }

   //@Test
    public void testGeneratedApplicationNumber() {
    ResponseEntity<?> result = controller.generateTrackingNumber("IN","UK",1.540,"2025-01-18T10:18:04+05:30","de619854-b59b-425e-9db4-943979e1bd49","RedBox Logistics","redbox-logistics");
      Assertions.assertNotNull(result.toString());
      Assertions.assertEquals(result.getStatusCode(),HttpStatus.OK);


   }
}





