package org.example.hospitalmanagementapi.mapper;

import org.example.hospitalmanagementapi.model.entity.Appointment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentRowMapper implements RowMapper<Appointment> {
    @Override
    public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Appointment.builder()
                .appointmentId(rs.getInt("appointmentId"))
                .appointmentPatientId(rs.getInt("appointmentPatientId"))
                .appointmentDoctorId(rs.getInt("appointmentDoctorId"))
                .appointmentDate(rs.getString("appointmentDate"))
                .appointmentStatus(rs.getString("appointmentStatus"))
                .appointmentCreatedAt(rs.getString("appointmentCreatedAt"))
                .appointmentUpdatedAt(rs.getString("appointmentUpdatedAt"))
                .build();
    }
}
