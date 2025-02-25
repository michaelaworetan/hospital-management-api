package org.example.hospitalmanagementapi.mapper;

import org.example.hospitalmanagementapi.model.entity.Staff;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffRowMapper implements RowMapper<Staff> {

    @Override
    public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Staff.builder()
                .staffId(rs.getInt("staffId"))
                .staffHospitalId(rs.getInt("staffHospitalId"))
                .staffPosition(rs.getString("staffPosition"))
                .staffDepartment(rs.getString("staffDepartment"))
                .staffSalary(rs.getBigDecimal("staffSalary"))
                .staffStatus(rs.getString("staffStatus"))
                .staffCreatedAt(rs.getString("staffCreatedAt"))
                .staffUpdatedAt(rs.getString("staffUpdatedAt"))
                .build();
    }
}