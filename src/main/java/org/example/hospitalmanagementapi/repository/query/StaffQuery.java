package org.example.hospitalmanagementapi.repository.query;

public class StaffQuery {

    //  Insert a new staff member (ensures staff is linked to a specific hospital)
    public static final String INSERT_STAFF = """
                INSERT INTO Staff (
                    staffHospitalId, staffPosition, staffDepartment,
                    staffSalary, staffStatus, staffCreatedAt, staffUpdatedAt
                )
                VALUES (
                    :staffHospitalId, :staffPosition, :staffDepartment,
                    :staffSalary, 'ACTIVE', GETDATE(), GETDATE()
                )
            """;

    //  Get all staff members for a specific hospital
    public static final String GET_BY_HOSPITAL_ID = """
                SELECT * FROM Staff
                WHERE staffHospitalId = :staffHospitalId
            """;

    //  Get staff by ID (Ensures hospital can only fetch their own staff)
    public static final String GET_BY_ID = """
                SELECT * FROM Staff
                WHERE staffId = :staffId AND staffHospitalId = :staffHospitalId
            """;

    // Update staff information within a hospital
    public static final String UPDATE_STAFF_BY_ID = """
                UPDATE Staff
                SET staffPosition = :staffPosition,
                    staffDepartment = :staffDepartment,
                    staffSalary = :staffSalary,
                    staffStatus = 'UPDATED',
                    staffUpdatedAt = GETDATE()
                WHERE staffId = :staffId AND staffHospitalId = :staffHospitalId
            """;

    // Ensures a hospital can only delete its own staff
    public static final String DELETE_STAFF_BY_ID = """
                UPDATE Staff
                SET staffStatus = 'DELETED',
                    staffUpdatedAt = GETDATE()
                WHERE staffId = :staffId AND staffHospitalId = :staffHospitalId
            """;
}
