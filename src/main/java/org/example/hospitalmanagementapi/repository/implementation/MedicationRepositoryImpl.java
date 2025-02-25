package org.example.hospitalmanagementapi.repository.implementation;

import org.example.hospitalmanagementapi.model.entity.Medication;
import org.example.hospitalmanagementapi.repository.Interface.MedicationRepository;
import org.example.hospitalmanagementapi.mapper.MedicationRowMapper;
import org.example.hospitalmanagementapi.repository.query.MedicationQuery;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MedicationRepositoryImpl implements MedicationRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final MedicationRowMapper medicationRowMapper;

    public MedicationRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.medicationRowMapper = new MedicationRowMapper();
    }

    @Override
    public int addMedication(Medication medication) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("medicationHospitalId", medication.getMedicationHospitalId());
        params.addValue("medicationName", medication.getMedicationName());
        params.addValue("medicationDescription", medication.getMedicationDescription());
        params.addValue("medicationManufacturer", medication.getMedicationManufacturer());
        params.addValue("medicationPrice", medication.getMedicationPrice());
        params.addValue("medicationStockQuantity", medication.getMedicationStockQuantity());
        params.addValue("medicationExpiryDate", medication.getMedicationExpiryDate());

        return jdbcTemplate.update(MedicationQuery.INSERT_MEDICATION, params);
    }

    @Override
    public List<Medication> getAllMedications() {
        return jdbcTemplate.query(MedicationQuery.GET_ALL_MEDICATIONS, medicationRowMapper);
    }

    @Override
    public Medication getMedicationById(int medicationId) {
        Map<String, Object> params = new HashMap<>();
        params.put("medicationId", medicationId);
        return jdbcTemplate.queryForObject(MedicationQuery.GET_MEDICATION_BY_ID, params, medicationRowMapper);
    }

    @Override
    public int updateMedication(Medication medication) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("medicationId", medication.getMedicationId());
        params.addValue("medicationHospitalId", medication.getMedicationHospitalId());
        params.addValue("medicationName", medication.getMedicationName());
        params.addValue("medicationDescription", medication.getMedicationDescription());
        params.addValue("medicationManufacturer", medication.getMedicationManufacturer());
        params.addValue("medicationPrice", medication.getMedicationPrice());
        params.addValue("medicationStockQuantity", medication.getMedicationStockQuantity());
        params.addValue("medicationExpiryDate", medication.getMedicationExpiryDate());
        params.addValue("medicationStatus", medication.getMedicationStatus());

        return jdbcTemplate.update(MedicationQuery.UPDATE_MEDICATION, params);
    }

    @Override
    public int deleteMedicationById(int medicationId) {
        Map<String, Object> params = new HashMap<>();
        params.put("medicationId", medicationId);
        return jdbcTemplate.update(MedicationQuery.DELETE_MEDICATION_BY_ID, params);
    }
}
