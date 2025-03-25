package com.example.tracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
public class TrackingNumberApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrackingNumberApiApplication.class, args);
    }
}

@RestController
class TrackingNumberController {
    private final AtomicLong counter = new AtomicLong();
    private final ConcurrentHashMap<String, Boolean> trackingNumbers = new ConcurrentHashMap<>();

    @GetMapping("/next-tracking-number")
    public TrackingResponse getTrackingNumber(
            @RequestParam String origin_country_id,
            @RequestParam String destination_country_id,
            @RequestParam String weight,
            @RequestParam String created_at,
            @RequestParam String customer_id,
            @RequestParam String customer_name,
            @RequestParam String customer_slug) {

        String trackingNumber;
        do {
            trackingNumber = generateTrackingNumber(origin_country_id, destination_country_id);
        } while (trackingNumbers.putIfAbsent(trackingNumber, true) != null);

        return new TrackingResponse(trackingNumber, created_at);
    }

    private String generateTrackingNumber(String origin, String destination) {
        return (origin + destination + counter.incrementAndGet())
                .toUpperCase()
                .replaceAll("[^A-Z0-9]", "")
                .substring(0, Math.min(16, origin.length() + destination.length() + 10));
    }
}

class TrackingResponse {
    private final String tracking_number;
    private final String created_at;

    public TrackingResponse(String tracking_number, String created_at) {
        this.tracking_number = tracking_number;
        this.created_at = created_at;
    }

    public String getTracking_number() {
        return tracking_number;
    }

    public String getCreated_at() {
        return created_at;
    }
}