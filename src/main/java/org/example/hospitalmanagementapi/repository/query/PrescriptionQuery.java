package org.example.hospitalmanagementapi.repository.query;

public class PrescriptionQuery {

    public static final String INSERT_PRESCRIPTION = """
            INSERT INTO Prescription (prescriptionAppointmentId, prescriptionNote, prescriptionPrescribedDate)
            VALUES (:prescriptionAppointmentId, :prescriptionNote, :prescriptionPrescribedDate)
            """;

    public static final String GET_ALL_PRESCRIPTIONS = """
            SELECT *
            FROM Prescription
            WHERE prescriptionStatus = 'ACTIVE'
            """;

    public static final String GET_PRESCRIPTION_BY_ID = """
            SELECT *
            FROM Prescription
            WHERE prescriptionId = :prescriptionId
              AND prescriptionStatus = 'ACTIVE'
            """;

    public static final String UPDATE_PRESCRIPTION = """
            UPDATE Prescription
            SET prescriptionAppointmentId   = :prescriptionAppointmentId,
                prescriptionNote           = :prescriptionNote,
                prescriptionPrescribedDate = :prescriptionPrescribedDate,
                prescriptionStatus         = :prescriptionStatus,
                prescriptionUpdatedAt      = CURRENT_TIMESTAMP()
            WHERE prescriptionId = :prescriptionId
            """;

    public static final String DELETE_PRESCRIPTION_BY_ID = """
            UPDATE Prescription
            SET prescriptionStatus    = 'DELETED',
                prescriptionUpdatedAt = CURRENT_TIMESTAMP()
            WHERE prescriptionId = :prescriptionId
            """;
}
