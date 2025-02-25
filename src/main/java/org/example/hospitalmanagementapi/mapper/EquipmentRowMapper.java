package org.example.hospitalmanagementapi.mapper;

import org.example.hospitalmanagementapi.model.entity.Equipment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipmentRowMapper implements RowMapper<Equipment> {
    @Override
    public Equipment mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Equipment.builder()
                .equipmentId(rs.getInt("equipmentId"))
                .equipmentHospitalId(rs.getInt("equipmentHospitalId"))
                .equipmentName(rs.getString("equipmentName"))
                .equipmentDescription(rs.getString("equipmentDescription"))
                .equipmentQuantity(rs.getInt("equipmentQuantity"))
                .equipmentStatus(rs.getString("equipmentStatus"))
                .equipmentCreatedAt(rs.getString("equipmentCreatedAt"))
                .equipmentUpdatedAt(rs.getString("equipmentUpdatedAt"))
                .build();
    }
}
