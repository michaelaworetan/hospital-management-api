package org.example.hospitalmanagementapi.repository.query;

public class DoctorQuery {

    // Insert a new doctor (linked to a specific staff in a hospital)
    public static final String INSERT_DOCTOR = """
            INSERT INTO Doctor (
                doctorStaffId, doctorSpeciality, doctorLicenseNumber,
                doctorYearsExperience, doctorStatus, doctorCreatedAt, doctorUpdatedAt
            ) VALUES (
                :doctorStaffId, :doctorSpeciality, :doctorLicenseNumber,
                :doctorYearsExperience, 'ACTIVE', GETDATE(), GETDATE()
            )
            """;

    public static final String GET_ALL_DOCTORS = "SELECT * FROM Doctor WHERE doctorStatus = 'ACTIVE'";

    public static final String GET_DOCTOR_BY_ID = "SELECT * FROM Doctor WHERE doctorId = :doctorId AND doctorStatus = 'ACTIVE'";

    public static final String UPDATE_DOCTOR = """
            UPDATE Doctor
            SET doctorStaffId = :doctorStaffId,
                doctorSpeciality = :doctorSpeciality,
                doctorLicenseNumber = :doctorLicenseNumber,
                doctorYearsExperience = :doctorYearsExperience,
                doctorStatus = :doctorStatus,
                doctorUpdatedAt = GETDATE()
            WHERE doctorId = :doctorId
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
