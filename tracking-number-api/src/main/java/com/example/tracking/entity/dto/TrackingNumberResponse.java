package com.example.tracking.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;


import java.time.OffsetDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrackingNumberResponse {

    private String trackingNumber;
    private OffsetDateTime createdAt;
   

    public TrackingNumberResponse() {
    }

    public TrackingNumberResponse(String trackingNumber,OffsetDateTime createdAt) {
        this.trackingNumber = trackingNumber;
        this.createdAt = createdAt;
      
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

   


   
}