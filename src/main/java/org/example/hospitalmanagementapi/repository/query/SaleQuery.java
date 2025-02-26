package org.example.hospitalmanagementapi.repository.query;

public class SaleQuery {

    public static final String INSERT_SALE = """
            INSERT INTO Sale (saleHospitalId, salesPrescriptionId, salesQuantity, salesTotalPrice, salesStatus, salesCreatedAt, salesUpdatedAt)
            VALUES (:saleHospitalId, :salesPrescriptionId, :salesQuantity, :salesTotalPrice, 'ACTIVE', GETDATE(), GETDATE())
            """;

    public static final String GET_ALL_SALES = "SELECT * FROM Sale WHERE salesStatus = 'ACTIVE'";

    public static final String GET_SALE_BY_ID = """
            SELECT * FROM Sale
            WHERE salesId = :salesId AND salesStatus = 'ACTIVE'
            """;

    public static final String UPDATE_SALE = """
            UPDATE Sale
            SET saleHospitalId = :saleHospitalId,
                salesPrescriptionId = :salesPrescriptionId,
                salesQuantity = :salesQuantity,
                salesTotalPrice = :salesTotalPrice,
                salesStatus = :salesStatus,
                salesUpdatedAt = GETDATE()
            WHERE salesId = :salesId
            """;

    public static final String DELETE_SALE_BY_ID = """
            UPDATE Sale
            SET salesStatus = 'DELETED',
                salesUpdatedAt = GETDATE()
            WHERE salesId = :salesId
            """;
}
