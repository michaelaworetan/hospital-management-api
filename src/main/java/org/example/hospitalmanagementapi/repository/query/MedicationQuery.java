package org.example.hospitalmanagementapi.repository.query;

public class MedicationQuery {

    public static final String INSERT_MEDICATION = """
            INSERT INTO Medication (medicationHospitalId, medicationName, medicationDescription, medicationManufacturer,
                medicationPrice, medicationStockQuantity, medicationExpiryDate
            )
            VALUES (:medicationHospitalId, :medicationName, :medicationDescription, :medicationManufacturer,
                :medicationPrice, :medicationStockQuantity, :medicationExpiryDate
            )
            """;

    public static final String GET_ALL_MEDICATIONS = """
            SELECT *
            FROM Medication
            WHERE medicationStatus = 'ACTIVE'
            """;

    public static final String GET_MEDICATION_BY_ID = """
            SELECT *
            FROM Medication
            WHERE medicationId = :medicationId
              AND medicationStatus = 'ACTIVE'
            """;

    public static final String UPDATE_MEDICATION = """
            UPDATE Medication
            SET medicationHospitalId    = :medicationHospitalId,
                medicationName         = :medicationName,
                medicationDescription  = :medicationDescription,
                medicationManufacturer = :medicationManufacturer,
                medicationPrice        = :medicationPrice,
                medicationStockQuantity = :medicationStockQuantity,
                medicationExpiryDate   = :medicationExpiryDate,
                medicationStatus       = :medicationStatus,
                medicationUpdatedAt    = GETDATE()
            WHERE medicationId = :medicationId
            """;

    public static final String UPDATE_MEDICATION_STOCK_QUANTITY = """
            UPDATE Medication
            SET medicationStockQuantity = :medicationStockQuantity,
                medicationUpdatedAt    = GETDATE()
            WHERE medicationId = :medicationId
            """;

    public static final String DELETE_MEDICATION_BY_ID = """
            UPDATE Medication
            SET medicationStatus    = 'DELETED',
                medicationUpdatedAt = GETDATE()
            WHERE medicationId = :medicationId
            """;

    public static final String GET_MEDICATIONS_BY_HOSPITAL_ID = """
            SELECT *
            FROM Medication
            WHERE medicationHospitalId = :medicationHospitalId
              AND medicationStatus = 'ACTIVE'
            """;

    public static final String GET_EXPIRED_MEDICATIONS_BY_HOSPITAL_ID = """
            SELECT *
            FROM Medication
            WHERE medicationHospitalId = :medicationHospitalId
              AND medicationStatus = 'ACTIVE'
              AND medicationExpiryDate < GETDATE()
            """;

    public static final String GENERATE_MEDICATION_REPORT = """
            SELECT m.medicationId,
                    m.medicationName,
                    m.medicationStockQuantity,
                    m.medicationPrice,
                    COALESCE(pi.medicationQuantity, 0) AS medicationQuantitySold,
                    (m.medicationPrice * COALESCE(pi.medicationQuantity, 0)) AS medicationRevenue
            FROM Medication m
            LEFT JOIN (
                SELECT prescriptionItemMedicationId, SUM(prescriptionItemQuantity) AS medicationQuantity
                FROM PrescriptionItem
                WHERE prescriptionItemStatus = 'ACTIVE'
                GROUP BY prescriptionItemMedicationId
            ) pi ON m.medicationId = pi.prescriptionItemMedicationId
            WHERE m.medicationHospitalId = :medicationHospitalId
              AND m.medicationStatus = 'ACTIVE'
            """;
}
