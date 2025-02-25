package org.example.hospitalmanagementapi.mapper;

import org.example.hospitalmanagementapi.model.entity.Hospital;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalRowMapper implements RowMapper<Hospital> {
    @Override
    public Hospital mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Hospital.builder()
                .hospitalId(rs.getInt("hospitalId"))
                .hospitalName(rs.getString("hospitalName"))
                .hospitalAddress(rs.getString("hospitalAddress"))
                .hospitalContactNo(rs.getString("hospitalContactNo"))
                .hospitalEmail(rs.getString("hospitalEmail"))
                .hospitalStatus(rs.getString("hospitalStatus"))
                .hospitalCreatedAt(rs.getString("hospitalCreatedAt"))
                .hospitalUpdatedAt(rs.getString("hospitalUpdatedAt"))
                .build();
    }
}
