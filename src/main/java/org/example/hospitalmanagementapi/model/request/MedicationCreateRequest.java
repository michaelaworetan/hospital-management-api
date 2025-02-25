package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicationCreateRequest {
    private String medicationName;
    private String medicationDescription;
    private String medicationManufacturer;
    private int medicationPrice;
    private int medicationHospitalId;
}
