package org.example.hospitalmanagementapi.mapper;

import org.example.hospitalmanagementapi.model.response.DoctorDetailsResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;

public class DoctorDetailsRowMapper implements RowMapper<DoctorDetailsResponse> {
    @Override
    public DoctorDetailsResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return DoctorDetailsResponse.builder()
                .staffName(rs.getString("staffName"))
                .doctorStaffId(rs.getInt("doctorStaffId"))
                .staffPosition(rs.getString("staffPosition"))
                .staffDepartment(rs.getString("staffDepartment"))
                .staffSalary(rs.getBigDecimal("staffSalary"))
                .doctorSpeciality(rs.getString("doctorSpeciality"))
                .build();
    }
}
