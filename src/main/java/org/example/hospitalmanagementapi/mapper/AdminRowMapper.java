package org.example.hospitalmanagementapi.mapper;

import org.example.hospitalmanagementapi.model.entity.Admin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRowMapper implements RowMapper<Admin> {
    @Override
    public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Admin.builder()
                .adminId(rs.getInt("adminId"))
                .adminName(rs.getString("adminName"))
                .adminHospitalId(rs.getInt("adminHospitalId"))
                .adminStatus(rs.getString("adminStatus"))
                .adminCreatedAt(rs.getString("adminCreatedAt"))
                .adminUpdatedAt(rs.getString("adminUpdatedAt"))
                .build();
    }
}
