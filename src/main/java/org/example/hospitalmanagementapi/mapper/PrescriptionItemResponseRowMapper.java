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
                .medicationName(rs.getString("medicationName"))
                .prescriptionItemQuantity(rs.getInt("prescriptionItemQuantity"))
                .prescriptionItemDosageInstruction(rs.getString("prescriptionItemDosageInstruction"))
                .build();
    }
}
