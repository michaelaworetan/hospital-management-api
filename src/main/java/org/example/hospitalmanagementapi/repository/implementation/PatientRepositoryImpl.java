package org.example.hospitalmanagementapi.repository.implementation;

import org.example.hospitalmanagementapi.mapper.PatientRowMapper;
import org.example.hospitalmanagementapi.model.entity.Patient;
import org.example.hospitalmanagementapi.repository.Interface.PatientRepository;
import org.example.hospitalmanagementapi.repository.query.PatientQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepositoryImpl implements PatientRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public PatientRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Patient> getAllPatients() {
        return jdbcTemplate.query(PatientQuery.GET_ALL_PATIENTS, new PatientRowMapper());
    }

    @Override
    public Patient getPatientById(int patientId) {
        MapSqlParameterSource params = new MapSqlParameterSource("patientId", patientId);
        return jdbcTemplate.queryForObject(PatientQuery.GET_PATIENT_BY_ID, params, new PatientRowMapper());
    }

    @Override
    public int createPatient(Patient patient) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("patientName", patient.getPatientName())
                .addValue("patientDateOfBirth", patient.getPatientDateOfBirth())
                .addValue("patientGender", patient.getPatientGender())
                .addValue("patientMedicalHistory", patient.getPatientMedicalHistory());
        return jdbcTemplate.update(PatientQuery.INSERT_PATIENT, params);
    }

    @Override
    public int updatePatient(Patient patient) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("patientId", patient.getPatientId())
                .addValue("patientName", patient.getPatientName())
                .addValue("patientDateOfBirth", patient.getPatientDateOfBirth())
                .addValue("patientGender", patient.getPatientGender())
                .addValue("patientMedicalHistory", patient.getPatientMedicalHistory())
                .addValue("patientStatus", patient.getPatientStatus());
        return jdbcTemplate.update(PatientQuery.UPDATE_PATIENT, params);
    }

    @Override
    public int deletePatientById(int patientId) {
        MapSqlParameterSource params = new MapSqlParameterSource("patientId", patientId);
        return jdbcTemplate.update(PatientQuery.DELETE_PATIENT_BY_ID, params);
    }
}
