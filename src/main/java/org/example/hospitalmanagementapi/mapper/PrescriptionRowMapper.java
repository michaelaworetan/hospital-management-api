package org.example.hospitalmanagementapi.mapper;

import org.example.hospitalmanagementapi.model.entity.Prescription;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrescriptionRowMapper implements RowMapper<Prescription> {

    @Override
    public Prescription mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Prescription.builder()
                .prescriptionId(rs.getInt("prescriptionId"))
                .prescriptionAppointmentId(rs.getString("prescriptionAppointmentId"))
                .prescriptionNote(rs.getString("prescriptionNote"))
                .prescriptionPrescribedDate(rs.getString("prescriptionPrescribedDate"))
                .prescriptionStatus(rs.getString("prescriptionStatus"))
                .prescriptionCreatedAt(rs.getString("prescriptionCreatedAt"))
                .prescriptionUpdatedAt(rs.getString("prescriptionUpdatedAt"))
                .build();
    }
}
