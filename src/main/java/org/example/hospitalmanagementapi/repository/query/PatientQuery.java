package org.example.hospitalmanagementapi.repository.query;

public class PatientQuery {
    public static final String INSERT_PATIENT = """
        INSERT INTO Patient (patientName, patientDateOfBirth, patientGender, patientMedicalHistory)
        VALUES (:patientName, :patientDateOfBirth, :patientGender, :patientMedicalHistory)
        """;

    public static final String GET_ALL_PATIENTS = "SELECT * FROM Patient WHERE patientStatus = 'ACTIVE'";

    public static final String GET_PATIENT_BY_ID = "SELECT * FROM Patient WHERE patientId = :patientId AND patientStatus = 'ACTIVE'";

    public static final String UPDATE_PATIENT = """
        UPDATE Patient
        SET patientName = :patientName,
            patientDateOfBirth = :patientDateOfBirth,
            patientGender = :patientGender,
            patientMedicalHistory = :patientMedicalHistory,
            patientStatus = :patientStatus,
            patientUpdatedAt = GETDATE()
        WHERE patientId = :patientId
        """;

    public static final String DELETE_PATIENT_BY_ID = """
        UPDATE Patient
        SET patientStatus = 'DELETED'
            patientUpdatedAt = GETDATE()
        WHERE patientId = :patientId
        """;
}
