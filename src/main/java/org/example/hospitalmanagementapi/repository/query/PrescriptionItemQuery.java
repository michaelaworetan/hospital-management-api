package org.example.hospitalmanagementapi.repository.query;

public class PrescriptionItemQuery {

    public static final String INSERT_PRESCRIPTION_ITEM = """
            INSERT INTO PrescriptionItem (prescriptionItemMedicationId, prescriptionItemQuantity, prescriptionItemDosageInstruction)
            VALUES (:prescriptionItemMedicationId, :prescriptionItemQuantity, :prescriptionItemDosageInstruction)
            """;

    public static final String GET_ALL_PRESCRIPTION_ITEMS = """
            SELECT *
            FROM PrescriptionItem
            WHERE prescriptionStatus = 'ACTIVE'
            """;

    public static final String GET_PRESCRIPTION_ITEM_BY_ID = """
            SELECT *
            FROM PrescriptionItem
            WHERE prescriptionItemId = :prescriptionItemId
              AND prescriptionStatus = 'ACTIVE'
            """;

    public static final String UPDATE_PRESCRIPTION_ITEM = """
            UPDATE PrescriptionItem
            SET prescriptionItemMedicationId    = :prescriptionItemMedicationId,
                prescriptionItemQuantity          = :prescriptionItemQuantity,
                prescriptionItemDosageInstruction = :prescriptionItemDosageInstruction,
                prescriptionStatus                = :prescriptionStatus,
                prescriptionUpdatedAt             = CURRENT_TIMESTAMP()
            WHERE prescriptionItemId = :prescriptionItemId
            """;

    public static final String DELETE_PRESCRIPTION_ITEM_BY_ID = """
            UPDATE PrescriptionItem
            SET prescriptionStatus    = 'DELETED',
                prescriptionUpdatedAt = CURRENT_TIMESTAMP()
            WHERE prescriptionItemId = :prescriptionItemId
            """;
}
