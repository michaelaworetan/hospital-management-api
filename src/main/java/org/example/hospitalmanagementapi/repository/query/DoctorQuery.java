package org.example.hospitalmanagementapi.repository.query;

public class DoctorQuery {

    // Insert a new doctor ( linked to a specific staff in a hospital)
    public static final String INSERT_DOCTOR = """
                INSERT INTO Doctor (
                    doctorStaffId, doctorName, doctorSpeciality, doctorLicenseNumber,
                    doctorYearsExperience, doctorStatus, doctorCreatedAt, doctorUpdatedAt
                )
                VALUES (
                    :doctorStaffId, :doctorName, :doctorSpeciality, :doctorLicenseNumber,
                    :doctorYearsExperience, 'ACTIVE', GETDATE(), GETDATE()
                )
            """;

    // Get doctor by ID (hospital restriction via `doctorStaffId`)
    public static final String GET_DOCTOR_BY_ID = """
                SELECT * FROM Doctor
                WHERE doctorId = :doctorId AND doctorStaffId = :doctorStaffId
            """;

    //  Update doctor information (updates within the same hospital)
    public static final String UPDATE_DOCTOR_BY_ID = """
                UPDATE Doctor
                SET doctorName = :doctorName,
                    doctorSpeciality = :doctorSpeciality,
                    doctorLicenseNumber = :doctorLicenseNumber,
                    doctorYearsExperience = :doctorYearsExperience,
                    doctorStatus = 'UPDATED',
                    doctorUpdatedAt = GETDATE()
                WHERE doctorId = :doctorId AND doctorStaffId = :doctorStaffId
            """;

    //  delete doctor by ID (only doctors within the same hospital can be deleted)
    public static final String DELETE_DOCTOR_BY_ID = """
                UPDATE Doctor
                SET doctorStatus = 'DELETED',
                    doctorUpdatedAt = GETDATE()
                WHERE doctorId = :doctorId AND doctorStaffId = :doctorStaffId
            """;
}
