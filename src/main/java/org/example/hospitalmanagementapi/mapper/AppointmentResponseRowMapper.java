package org.example.hospitalmanagementapi.mapper;

import org.example.hospitalmanagementapi.model.entity.Appointment;
import org.example.hospitalmanagementapi.model.response.AppointmentResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentResponseRowMapper implements RowMapper<AppointmentResponse> {
    @Override
    public AppointmentResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return AppointmentResponse.builder()
                .appointmentId(rs.getInt("appointmentId"))
                .appointmentPatientId(rs.getInt("appointmentPatientId"))
                .appointmentDoctorId(rs.getInt("appointmentDoctorId"))
                .appointmentHospitalId(rs.getInt("appointmentHospitalId"))
                .appointmentDate(rs.getString("appointmentDate"))
                .appointmentStatus(rs.getString("appointmentStatus"))
                .appointmentCreatedAt(rs.getString("appointmentCreatedAt"))
                .appointmentUpdatedAt(rs.getString("appointmentUpdatedAt"))
                .appointmentDoctorName(rs.getString("appointmentDoctorName"))
                .appointmentPatientName(rs.getString("appointmentPatientName"))
                .build();
    }
}

