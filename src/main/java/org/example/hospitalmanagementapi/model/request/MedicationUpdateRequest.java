package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicationUpdateRequest {
    private String medicationName;
    private String medicationDescription;
    private String medicationManufacturer;
    private int medicationPrice;
    private int medicationHospitalId;
    private int medicationStockQuantity;
    private String medicationExpiryDate;
    private String medicationStatus;
}
