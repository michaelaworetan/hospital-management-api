package org.example.hospitalmanagementapi.mapper;

import org.example.hospitalmanagementapi.model.response.MedicationResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicationResponseRowMapper implements RowMapper<MedicationResponse> {
    @Override
    public MedicationResponse mapRow(ResultSet resultSet, int i) throws SQLException {
        return MedicationResponse.builder()
                .medicationId(resultSet.getInt("medicationId"))
                .medicationName(resultSet.getString("medicationName"))
                .medicationStockQuantity(resultSet.getInt("medicationStockQuantity"))
                .medicationPrice(resultSet.getDouble("medicationPrice"))
                .medicationQuantitySold(resultSet.getInt("medicationQuantitySold"))
                .medicationRevenue(resultSet.getDouble("medicationRevenue"))
                .build();
    }
}
