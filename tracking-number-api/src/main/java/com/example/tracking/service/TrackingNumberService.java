package com.example.tracking.service;


import org.springframework.stereotype.Service;

import com.example.tracking.entity.TrackingNumber;
import com.example.tracking.entity.dto.TrackingNumberRequest;
import com.example.tracking.entity.dto.TrackingNumberResponse;

import java.time.OffsetDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TrackingNumberService {

    private final AtomicLong counter = new AtomicLong();
    private final ConcurrentHashMap<String, Boolean> trackingNumbers = new ConcurrentHashMap<>();


    public TrackingNumberResponse createTrackingNumber(TrackingNumberRequest request) {

        String trackingNumber;
        do {
            trackingNumber = generateTrackingNumber(request.getOriginCountryId(), request.getDestinationCountryId());
        } while (trackingNumbers.putIfAbsent(trackingNumber, true) != null);

    
        TrackingNumber result =new TrackingNumber();
        result.setTrackingNumber(trackingNumber);
        return new TrackingNumberResponse(result.getTrackingNumber(),OffsetDateTime.now());

    }

    private String generateTrackingNumber(String origin, String destination) {
        return (origin + origin.hashCode() + destination + destination.hashCode() + String.valueOf(counter.incrementAndGet()))
                .toUpperCase();
              
    }
}