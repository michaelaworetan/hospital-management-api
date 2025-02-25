package org.example.hospitalmanagementapi.repository.implementation;

import org.example.hospitalmanagementapi.model.entity.Prescription;
import org.example.hospitalmanagementapi.repository.Interface.PrescriptionRepository;
import org.example.hospitalmanagementapi.mapper.PrescriptionRowMapper;
import org.example.hospitalmanagementapi.repository.query.PrescriptionQuery;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PrescriptionRepositoryImpl implements PrescriptionRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final PrescriptionRowMapper prescriptionRowMapper;

    public PrescriptionRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.prescriptionRowMapper = new PrescriptionRowMapper();
    }

    @Override
    public int createPrescription(Prescription prescription) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("prescriptionAppointmentId", prescription.getPrescriptionAppointmentId());
        params.addValue("prescriptionNote", prescription.getPrescriptionNote());
        params.addValue("prescriptionPrescribedDate", prescription.getPrescriptionPrescribedDate());
        return jdbcTemplate.update(PrescriptionQuery.INSERT_PRESCRIPTION, params);
    }

    @Override
    public List<Prescription> getAllPrescriptions() {
        return jdbcTemplate.query(PrescriptionQuery.GET_ALL_PRESCRIPTIONS, prescriptionRowMapper);
    }

    @Override
    public Prescription getPrescriptionById(int prescriptionId) {
        Map<String, Object> params = new HashMap<>();
        params.put("prescriptionId", prescriptionId);
        return jdbcTemplate.queryForObject(PrescriptionQuery.GET_PRESCRIPTION_BY_ID, params, prescriptionRowMapper);
    }

    @Override
    public int updatePrescription(Prescription prescription) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("prescriptionId", prescription.getPrescriptionId());
        params.addValue("prescriptionAppointmentId", prescription.getPrescriptionAppointmentId());
        params.addValue("prescriptionNote", prescription.getPrescriptionNote());
        params.addValue("prescriptionPrescribedDate", prescription.getPrescriptionPrescribedDate());
        params.addValue("prescriptionStatus", prescription.getPrescriptionStatus());
        return jdbcTemplate.update(PrescriptionQuery.UPDATE_PRESCRIPTION, params);
    }

    @Override
    public int deletePrescriptionById(int prescriptionId) {
        Map<String, Object> params = new HashMap<>();
        params.put("prescriptionId", prescriptionId);
        return jdbcTemplate.update(PrescriptionQuery.DELETE_PRESCRIPTION_BY_ID, params);
    }
}
