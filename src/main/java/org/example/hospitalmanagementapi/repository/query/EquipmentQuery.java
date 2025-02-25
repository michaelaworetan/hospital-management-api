package org.example.hospitalmanagementapi.repository.query;

public class EquipmentQuery {
    public static final String INSERT_EQUIPMENT = """
        INSERT INTO Equipment (equipmentHospitalId, equipmentName, equipmentDescription, equipmentQuantity)
        VALUES (:equipmentHospitalId, :equipmentName, :equipmentDescription, :equipmentQuantity)
        """;

    public static final String GET_ALL_EQUIPMENTS = "SELECT * FROM Equipment WHERE equipmentStatus = 'ACTIVE'";

    public static final String GET_EQUIPMENT_BY_ID = "SELECT * FROM Equipment WHERE equipmentId = :equipmentId AND equipmentStatus = 'ACTIVE'";

    public static final String UPDATE_EQUIPMENT = """
        UPDATE Equipment
        SET equipmentHospitalId = :equipmentHospitalId,
            equipmentName = :equipmentName,
            equipmentDescription = :equipmentDescription,
            equipmentQuantity = :equipmentQuantity,
            equipmentStatus = :equipmentStatus,
            equipmentUpdatedAt = GETDATE()
        WHERE equipmentId = :equipmentId
        """;

    public static final String DELETE_EQUIPMENT_BY_ID = """
        UPDATE Equipment
        SET equipmentStatus = 'DELETED',
            equipmentUpdatedAt = GETDATE()
        WHERE equipmentId = :equipmentId
        """;
}
