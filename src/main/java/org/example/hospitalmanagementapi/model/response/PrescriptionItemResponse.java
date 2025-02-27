package org.example.hospitalmanagementapi.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrescriptionItemResponse {
    private int prescriptionItemId;
    private String medicationName;
    private int prescriptionItemQuantity;
    private String prescriptionItemDosageInstruction;
}
