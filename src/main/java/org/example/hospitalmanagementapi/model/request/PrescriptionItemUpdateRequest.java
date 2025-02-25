package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrescriptionItemUpdateRequest {
    private int prescriptionItemId;
    private String prescriptionItemMedicationId;
    private int prescriptionItemQuantity;
    private String prescriptionItemDosageInstruction;
    private String prescriptionStatus;
}
