package org.example.hospitalmanagementapi.mapper;

import org.example.hospitalmanagementapi.model.entity.Doctor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorRowMapper implements RowMapper<Doctor> {
    @Override
    public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Doctor.builder()
                .doctorId(rs.getInt("doctorId"))
                .doctorStaffId(rs.getInt("doctorStaffId"))
                .doctorSpeciality(rs.getString("doctorSpeciality"))
                .doctorLicenseNumber(rs.getString("doctorLicenseNumber"))
                .doctorYearsExperience(rs.getInt("doctorYearsExperience"))
                .doctorStatus(rs.getString("doctorStatus"))
                .doctorCreatedAt(rs.getString("doctorCreatedAt"))
                .doctorUpdatedAt(rs.getString("doctorUpdatedAt"))
                .build();
    }
}
