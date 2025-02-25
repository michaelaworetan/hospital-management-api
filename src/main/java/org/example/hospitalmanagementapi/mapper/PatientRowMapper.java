package org.example.hospitalmanagementapi.mapper;

import org.example.hospitalmanagementapi.model.entity.Patient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientRowMapper implements RowMapper<Patient> {
    @Override
    public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Patient.builder()
                .patientId(rs.getInt("patientId"))
                .patientName(rs.getString("patientName"))
                .patientDateOfBirth(rs.getString("patientDateOfBirth"))
                .patientGender(rs.getString("patientGender"))
                .patientMedicalHistory(rs.getString("patientMedicalHistory"))
                .patientStatus(rs.getString("patientStatus"))
                .patientCreatedAt(rs.getString("patientCreatedAt"))
                .patientUpdatedAt(rs.getString("patientUpdatedAt"))
                .build();
    }
}
