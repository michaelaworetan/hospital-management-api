package org.example.hospitalmanagementapi.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicationResponse {
    private int medicationId;
    private String medicationName;
    private int medicationStockQuantity;
    private Double medicationPrice;
    private int medicationQuantitySold;
    private Double medicationRevenue;
}
