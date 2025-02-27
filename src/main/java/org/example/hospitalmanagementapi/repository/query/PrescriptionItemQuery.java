package org.example.hospitalmanagementapi.repository.query;

public class PrescriptionItemQuery {

    public static final String INSERT_PRESCRIPTION_ITEM = """
            INSERT INTO PrescriptionItem (prescriptionItemMedicationId, prescriptionItemPrescriptionId, prescriptionItemQuantity, prescriptionItemDosageInstruction)
            VALUES (:prescriptionItemMedicationId, :prescriptionItemPrescriptionId, :prescriptionItemQuantity, :prescriptionItemDosageInstruction)
            """;

    public static final String GET_ALL_PRESCRIPTION_ITEMS = """
            SELECT *
            FROM PrescriptionItem
            WHERE prescriptionItemStatus = 'ACTIVE'
            """;

    public static final String GET_PRESCRIPTION_ITEM_BY_ID = """
            SELECT *
            FROM PrescriptionItem
            WHERE prescriptionItemId = :prescriptionItemId
              AND prescriptionItemStatus = 'ACTIVE'
            """;

    public static final String UPDATE_PRESCRIPTION_ITEM = """
            UPDATE PrescriptionItem
            SET prescriptionItemMedicationId    = :prescriptionItemMedicationId,
                prescriptionItemPrescriptionId = :prescriptionItemPrescriptionId,
                prescriptionItemQuantity          = :prescriptionItemQuantity,
                prescriptionItemDosageInstruction = :prescriptionItemDosageInstruction,
                prescriptionItemStatus                = :prescriptionStatus,
                prescriptionItemUpdatedAt             = GETDATE()
            WHERE prescriptionItemId = :prescriptionItemId
            """;

    public static final String DELETE_PRESCRIPTION_ITEM_BY_ID = """
            UPDATE PrescriptionItem
            SET prescriptionItemStatus    = 'DELETED',
                prescriptionItemUpdatedAt = GETDATE()
            WHERE prescriptionItemId = :prescriptionItemId
            """;

    public static final String GET_PRESCRIPTION_ITEMS_BY_APPOINTMENT_ID = """
            SELECT
                 pi.prescriptionItemId,
                 pi.prescriptionItemQuantity,
                 pi.prescriptionItemDosageInstruction,
                 m.medicationName
             FROM PrescriptionItem pi
             JOIN Prescription p ON pi.prescriptionItemPrescriptionId = p.prescriptionId
             JOIN Appointment a ON p.prescriptionAppointmentId = a.appointmentId
             JOIN Medication m ON pi.prescriptionItemMedicationId = m.medicationId
            WHERE a.appointmentId = :appointmentId
              AND a.appointmentStatus = 'ACTIVE'
              AND p.prescriptionStatus = 'ACTIVE'
              AND pi.prescriptionItemStatus = 'ACTIVE'
            """;
}
