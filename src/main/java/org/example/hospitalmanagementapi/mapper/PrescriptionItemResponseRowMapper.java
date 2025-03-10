package org.example.hospitalmanagementapi.mapper;

import org.example.hospitalmanagementapi.model.response.PrescriptionItemResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrescriptionItemResponseRowMapper implements RowMapper<PrescriptionItemResponse> {

    @Override
    public PrescriptionItemResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PrescriptionItemResponse.builder()
                .prescriptionItemId(rs.getInt("prescriptionItemId"))
                .prescriptionItemMedicationId(rs.getInt("prescriptionItemMedicationId"))
                .prescriptionItemPrescriptionId(rs.getInt("prescriptionItemPrescriptionId"))
                .prescriptionItemQuantity(rs.getInt("prescriptionItemQuantity"))
                .prescriptionItemDosageInstruction(rs.getString("prescriptionItemDosageInstruction"))
                .prescriptionItemStatus(rs.getString("prescriptionItemStatus"))
                .prescriptionItemCreatedAt(rs.getString("prescriptionItemCreatedAt"))
                .prescriptionItemUpdatedAt(rs.getString("prescriptionItemUpdatedAt"))
                .medicationName(rs.getString("medicationName"))
                .medicationStockQuantity(rs.getInt("medicationStockQuantity"))
                .medicationPrice(rs.getDouble("medicationPrice"))
                .build();
    }
}
