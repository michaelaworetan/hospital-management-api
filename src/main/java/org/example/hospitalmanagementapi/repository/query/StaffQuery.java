package org.example.hospitalmanagementapi.repository.query;

public class StaffQuery {

    // Insert a new staff
    public static final String INSERT_STAFF = """
                INSERT INTO Staff (
                    staffName, staffHospitalId, staffPosition, staffDepartment,
                    staffSalary, staffStatus, staffCreatedAt, staffUpdatedAt
                )
                VALUES (
                    :staffName, :staffHospitalId, :staffPosition, :staffDepartment,
                    :staffSalary, 'ACTIVE', GETDATE(), GETDATE()
                )
            """;

    // Get all active staff for a specific hospital
    public static final String GET_BY_HOSPITAL_ID = """
                SELECT * FROM Staff
                WHERE staffHospitalId = :staffHospitalId AND staffStatus = 'ACTIVE'
            """;

    // Get active staff by ID
    public static final String GET_BY_ID = """
                SELECT * FROM Staff
                WHERE staffId = :staffId AND staffHospitalId = :staffHospitalId
                AND staffStatus = 'ACTIVE'
            """;

    // Update staff information within a hospital
    public static final String UPDATE_STAFF_BY_ID = """
                UPDATE Staff
                SET staffName = :staffName,
                    staffPosition = :staffPosition,
                    staffDepartment = :staffDepartment,
                    staffSalary = :staffSalary,
                    staffStatus = :staffStatus,
                    staffUpdatedAt = GETDATE()
                WHERE staffId = :staffId AND staffHospitalId = :staffHospitalId
            """;

    // An hospital can only delete its own staff
    public static final String DELETE_STAFF_BY_ID = """
                UPDATE Staff
                SET staffStatus = 'DELETED',
                    staffUpdatedAt = GETDATE()
                WHERE staffId = :staffId AND staffHospitalId = :staffHospitalId
            """;
}
