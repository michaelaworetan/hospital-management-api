package org.example.hospitalmanagementapi.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrescriptionItemResponse {
    private int prescriptionItemId;
    private int prescriptionItemMedicationId;
    private int prescriptionItemPrescriptionId;
    private int prescriptionItemQuantity;
    private String prescriptionItemDosageInstruction;
    private String prescriptionItemStatus;
    private String prescriptionItemCreatedAt;
    private String prescriptionItemUpdatedAt;
    private String medicationName;
    private int medicationStockQuantity;
    private Double medicationPrice;
}
