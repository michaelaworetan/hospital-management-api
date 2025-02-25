package org.example.hospitalmanagementapi.repository.query;

public class AdminQuery {
    public static final String INSERT_ADMIN = """
            INSERT INTO Admin (adminName, adminHospitalId)
            VALUES (:adminName, :adminHospitalId)
            """;

    public static final String GET_ALL_ADMINS = "SELECT * FROM Admin WHERE adminStatus = 'ACTIVE'";

    public static final String GET_ADMIN_BY_ID = "SELECT * FROM Admin WHERE adminId = :adminId AND adminStatus = 'ACTIVE'";

    public static final String UPDATE_ADMIN = """
            UPDATE Admin
            SET adminName = :adminName,
                adminHospitalId = :adminHospitalId,
                adminStatus = :adminStatus,
                adminUpdatedAt = GETDATE()
            WHERE adminId = :adminId
            """;

    public static final String DELETE_ADMIN_BY_ID = """
            UPDATE Admin
            SET adminStatus = 'DELETED',
                adminUpdatedAt = GETDATE()
            WHERE adminId = :adminId
            """;
}
