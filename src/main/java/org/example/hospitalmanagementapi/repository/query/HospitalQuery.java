package org.example.hospitalmanagementapi.repository.query;

public class HospitalQuery {

    public static final String INSERT_HOSPITAL = """
            INSERT INTO Hospital (hospitalName, hospitalAddress, hospitalContactNo, hospitalEmail)
            VALUES (:hospitalName, :hospitalAddress, :hospitalContactNo, :hospitalEmail)
            """;

    public static final String GET_ALL_HOSPITALS = "SELECT * FROM Hospital WHERE hospitalStatus = 'ACTIVE'";

    public static final String GET_HOSPITAL_BY_ID = "SELECT * FROM Hospital WHERE hospitalId = :hospitalId AND hospitalStatus = 'ACTIVE'";

    public static final String UPDATE_HOSPITAL = """
            UPDATE Hospital
            SET hospitalName = :hospitalName,
                hospitalAddress = :hospitalAddress,
                hospitalContactNo = :hospitalContactNo,
                hospitalEmail = :hospitalEmail,
                hospitalStatus = :hospitalStatus,
                hospitalUpdatedAt = GETDATE()
            WHERE hospitalId = :hospitalId
            """;

    public static final String DELETE_HOSPITAL_BY_ID = """
            UPDATE Hospital
            SET hospitalStatus = 'DELETED',
                hospitalUpdatedAt = GETDATE()
            WHERE hospitalId = :hospitalId
            """;
}
