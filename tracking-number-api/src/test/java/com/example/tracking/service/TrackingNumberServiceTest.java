package com.example.tracking.service;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import org.mockito.InjectMocks;
import com.example.tracking.entity.dto.TrackingNumberRequest;
import com.example.tracking.entity.dto.TrackingNumberResponse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TrackingNumberServiceTest {
    TrackingNumberRequest request;
    @InjectMocks
    TrackingNumberService service;

    @BeforeEach
    public void setUp() {
   
       request = new TrackingNumberRequest("IN","UK",1.540,OffsetDateTime.now(),"de619854-b59b-425e-9db4-943979e1bd49","RedBox Logistics","redbox-logistics");

   }

   //@Test
    public void testGeneratedApplicationNumber() {
      TrackingNumberResponse result = service.createTrackingNumber(request);
      Assertions.assertNotNull(result.getTrackingNumber());
      Assertions.assertNotNull(result.getCreatedAt());


   }
}


