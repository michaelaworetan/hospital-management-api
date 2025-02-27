package org.example.hospitalmanagementapi.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrescriptionItem {
    private int prescriptionItemId;
    private int prescriptionItemMedicationId;
    private int prescriptionItemPrescriptionId;
    private int prescriptionItemQuantity;
    private String prescriptionItemDosageInstruction;
    private String prescriptionItemStatus;
    private String prescriptionItemCreatedAt;
    private String prescriptionItemUpdatedAt;
}
