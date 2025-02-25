package org.example.hospitalmanagementapi.mapper;

import org.example.hospitalmanagementapi.model.entity.PrescriptionItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrescriptionItemRowMapper implements RowMapper<PrescriptionItem> {

    @Override
    public PrescriptionItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PrescriptionItem.builder()
                .prescriptionItemId(rs.getInt("prescriptionItemId"))
                .prescriptionItemMedicationId(rs.getString("prescriptionItemMedicationId"))
                .prescriptionItemQuantity(rs.getInt("prescriptionItemQuantity"))
                .prescriptionItemDosageInstruction(rs.getString("prescriptionItemDosageInstruction"))
                .prescriptionStatus(rs.getString("prescriptionStatus"))
                .prescriptionCreatedAt(rs.getString("prescriptionCreatedAt"))
                .prescriptionUpdatedAt(rs.getString("prescriptionUpdatedAt"))
                .build();
    }
}
