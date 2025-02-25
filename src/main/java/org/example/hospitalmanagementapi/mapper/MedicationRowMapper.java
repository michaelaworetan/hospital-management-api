package org.example.hospitalmanagementapi.mapper;

import org.example.hospitalmanagementapi.model.entity.Medication;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicationRowMapper implements RowMapper<Medication> {

    @Override
    public Medication mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Medication.builder()
                .medicationId(rs.getInt("medicationId"))
                .medicationHospitalId(rs.getInt("medicationHospitalId"))
                .medicationName(rs.getString("medicationName"))
                .medicationDescription(rs.getString("medicationDescription"))
                .medicationManufacturer(rs.getString("medicationManufacturer"))
                .medicationPrice(rs.getInt("medicationPrice"))
                .medicationStockQuantity(rs.getInt("medicationStockQuantity"))
                .medicationExpiryDate(rs.getString("medicationExpiryDate"))
                .medicationStatus(rs.getString("medicationStatus"))
                .medicationCreatedAt(rs.getString("medicationCreatedAt"))
                .medicationUpdatedAt(rs.getString("medicationUpdatedAt"))
                .build();
    }
}
