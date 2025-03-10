package org.example.hospitalmanagementapi.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Medication {
    private int medicationId;
    private int medicationHospitalId;
    private String medicationName;
    private String medicationDescription;
    private String medicationManufacturer;
    private Double medicationPrice;
    private int medicationStockQuantity;
    private String medicationExpiryDate;
    private String medicationStatus;
    private String medicationCreatedAt;
    private String medicationUpdatedAt;
}
