package org.example.hospitalmanagementapi.repository.query;

public class DoctorQuery {

    // Insert a new doctor (linked to a specific staff in a hospital)
    public static final String INSERT_DOCTOR = """
                INSERT INTO Doctor (
                    doctorStaffId, doctorSpeciality, doctorLicenseNumber,
                    doctorYearsExperience, doctorStatus, doctorCreatedAt, doctorUpdatedAt
                )
                VALUES (
                    :doctorStaffId, :doctorSpeciality, :doctorLicenseNumber,
                    :doctorYearsExperience, 'ACTIVE', GETDATE(), GETDATE()
                )
            """;

    // Get all active doctors for a specific hospital (staff-hospital relationship)
    public static final String GET_DOCTORS_BY_HOSPITAL_ID = """
                SELECT d.*
                FROM Doctor d
                JOIN Staff s ON d.doctorStaffId = s.staffId
                WHERE s.staffHospitalId = :hospitalId AND d.doctorStatus = 'ACTIVE'
            """;

    public static final String GET_DOCTOR_BY_ID = """
                SELECT d.*
                FROM Doctor d
                JOIN Staff s ON d.doctorStaffId = s.staffId
                WHERE d.doctorId = :doctorId AND s.staffHospitalId = :hospitalId
                  AND d.doctorStatus = 'ACTIVE'
            """;

    public static final String UPDATE_DOCTOR_BY_ID = """
                UPDATE Doctor
                SET doctorSpeciality = :doctorSpeciality,
                    doctorLicenseNumber = :doctorLicenseNumber,
                    doctorYearsExperience = :doctorYearsExperience,
                    doctorStatus = :doctorStatus,
                    doctorUpdatedAt = GETDATE()
                WHERE doctorId = :doctorId AND doctorStaffId IN (
                    SELECT staffId FROM Staff WHERE staffHospitalId = :hospitalId
                )
            """;

    public static final String DELETE_DOCTOR_BY_ID = """
                UPDATE Doctor
                SET doctorStatus = 'DELETED',
                    doctorUpdatedAt = GETDATE()
                WHERE doctorId = :doctorId AND doctorStaffId IN (
                    SELECT staffId FROM Staff WHERE staffHospitalId = :hospitalId
                )
            """;
}
