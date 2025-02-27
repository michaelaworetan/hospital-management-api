package org.example.hospitalmanagementapi.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrescriptionItemCreateRequest {
    private int prescriptionItemMedicationId;
    private int prescriptionItemPrescriptionId;
    private int prescriptionItemQuantity;
    private String prescriptionItemDosageInstruction;
}
