package com.example.tracking.entity.dto;

import java.time.OffsetDateTime;

public class TrackingNumberRequest {

    private String originCountryId;
    private String destinationCountryId;
    private double weight;
    private OffsetDateTime createdAt;
    private String customerId;
    private String customerName;
    private String customerSlug;

    public TrackingNumberRequest() {
    }

    public TrackingNumberRequest(String originCountryId, String destinationCountryId, double weight, OffsetDateTime createdAt, String customerId, String customerName, String customerSlug) {
        this.originCountryId = originCountryId;
        this.destinationCountryId = destinationCountryId;
        this.weight = weight;
        this.createdAt = createdAt;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSlug = customerSlug;
    }

    public String getOriginCountryId() {
        return originCountryId;
    }

    public void setOriginCountryId(String originCountryId) {
        this.originCountryId = originCountryId;
    }

    public String getDestinationCountryId() {
        return destinationCountryId;
    }

    public void setDestinationCountryId(String destinationCountryId) {
        this.destinationCountryId = destinationCountryId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSlug() {
        return customerSlug;
    }

    public void setCustomerSlug(String customerSlug) {
        this.customerSlug = customerSlug;
    }
}