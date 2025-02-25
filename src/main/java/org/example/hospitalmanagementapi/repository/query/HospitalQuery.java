package org.example.hospitalmanagementapi.repository.query;

public class HospitalQuery {

    public static final String INSERT_HOSPITAL = """
                INSERT INTO Hospital (hospitalName, hospitalAddress, hospitalContactNo, hospitalStatus, hospitalCreatedAt, hospitalUpdatedAt)
                VALUES (:hospitalName, :hospitalAddress, :hospitalContactNo, :hospitalStatus, GETDATE(), GETDATE())
            """;

    public static final String GET_ALL = """
                SELECT * FROM Hospital
            """;

    public static final String GET_BY_ID = """
                SELECT * FROM Hospital WHERE hospitalId = :hospitalId
            """;

    public static final String UPDATE_HOSPITAL_BY_ID = """
                UPDATE Hospital
                SET hospitalName = :hospitalName, hospitalAddress = :hospitalAddress, 
                    hospitalContactNo = :hospitalContactNo, 
                    hospitalStatus = 'UPDATED', hospitalUpdatedAt = GETDATE()
                WHERE hospitalId = :hospitalId
            """;

    public static final String DELETE_HOSPITAL_BY_ID = """
                UPDATE Hospital
                SET hospitalStatus = 'DELETED',
                    hospitalUpdatedAt = GETDATE()
                WHERE hospitalId = :hospitalId
            """;

}

