package org.example.hospitalmanagementapi.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrescriptionItem {
    private int prescriptionItemId;
    private String prescriptionItemMedicationId;
    private int prescriptionItemQuantity;
    private String prescriptionItemDosageInstruction;
    private String prescriptionStatus;
    private String prescriptionCreatedAt;
    private String prescriptionUpdatedAt;
}
