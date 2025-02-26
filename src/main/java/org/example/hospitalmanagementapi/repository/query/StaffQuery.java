package org.example.hospitalmanagementapi.repository.query;

public class StaffQuery {

    public static final String INSERT_STAFF = """
            INSERT INTO Staff (staffHospitalId, staffName, staffPosition, staffDepartment, staffSalary)
            VALUES (:staffHospitalId, :staffName, :staffPosition, :staffDepartment, :staffSalary)
            """;

    public static final String GET_ALL_STAFF = "SELECT * FROM Staff WHERE staffStatus = 'ACTIVE'";

    public static final String GET_STAFF_BY_ID = "SELECT * FROM Staff WHERE staffId = :staffId AND staffStatus = 'ACTIVE'";

    public static final String GET_ALL_STAFF_BY_HOSPITAL_ID = """
            SELECT * FROM Staff
            WHERE staffHospitalId = :staffHospitalId AND staffStatus = 'ACTIVE'
            """;

    public static final String GET_STAFF_BY_SALARY_RANGE = """
            SELECT * FROM Staff
            WHERE staffSalary BETWEEN :minSalary AND :maxSalary
            AND staffStatus = 'ACTIVE'
            """;

    public static final String UPDATE_STAFF = """
            UPDATE Staff
            SET staffHospitalId = :staffHospitalId,
                staffName = :staffName,
                staffPosition = :staffPosition,
                staffDepartment = :staffDepartment,
                staffSalary = :staffSalary,
                staffStatus = :staffStatus,
                staffUpdatedAt = GETDATE()
            WHERE staffId = :staffId
            """;

    public static final String DELETE_STAFF_BY_ID = """
            UPDATE Staff
            SET staffStatus = 'DELETED',
                staffUpdatedAt = GETDATE()
            WHERE staffId = :staffId
            """;

}
