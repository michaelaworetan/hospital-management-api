package org.example.hospitalmanagementapi.repository.implementation;

import org.example.hospitalmanagementapi.model.entity.PrescriptionItem;
import org.example.hospitalmanagementapi.model.response.PrescriptionItemResponse;
import org.example.hospitalmanagementapi.repository.Interface.PrescriptionItemRepository;
import org.example.hospitalmanagementapi.mapper.PrescriptionItemRowMapper;
import org.example.hospitalmanagementapi.mapper.PrescriptionItemResponseRowMapper;
import org.example.hospitalmanagementapi.repository.query.PrescriptionItemQuery;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PrescriptionItemRepositoryImpl implements PrescriptionItemRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final PrescriptionItemRowMapper prescriptionItemRowMapper;

    public PrescriptionItemRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.prescriptionItemRowMapper = new PrescriptionItemRowMapper();
    }

    @Override
    public int createPrescriptionItem(PrescriptionItem prescriptionItem) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("prescriptionItemMedicationId", prescriptionItem.getPrescriptionItemMedicationId());
        params.addValue("prescriptionItemQuantity", prescriptionItem.getPrescriptionItemQuantity());
        params.addValue("prescriptionItemDosageInstruction", prescriptionItem.getPrescriptionItemDosageInstruction());
        return jdbcTemplate.update(PrescriptionItemQuery.INSERT_PRESCRIPTION_ITEM, params);
    }

    @Override
    public List<PrescriptionItem> getAllPrescriptionItems() {
        return jdbcTemplate.query(PrescriptionItemQuery.GET_ALL_PRESCRIPTION_ITEMS, prescriptionItemRowMapper);
    }

    @Override
    public PrescriptionItem getPrescriptionItemById(int prescriptionItemId) {
        Map<String, Object> params = new HashMap<>();
        params.put("prescriptionItemId", prescriptionItemId);
        return jdbcTemplate.queryForObject(PrescriptionItemQuery.GET_PRESCRIPTION_ITEM_BY_ID, params, prescriptionItemRowMapper);
    }

    @Override
    public int updatePrescriptionItem(PrescriptionItem prescriptionItem) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("prescriptionItemId", prescriptionItem.getPrescriptionItemId());
        params.addValue("prescriptionItemMedicationId", prescriptionItem.getPrescriptionItemMedicationId());
        params.addValue("prescriptionItemQuantity", prescriptionItem.getPrescriptionItemQuantity());
        params.addValue("prescriptionItemDosageInstruction", prescriptionItem.getPrescriptionItemDosageInstruction());
        params.addValue("prescriptionStatus", prescriptionItem.getPrescriptionStatus());
        return jdbcTemplate.update(PrescriptionItemQuery.UPDATE_PRESCRIPTION_ITEM, params);
    }

    @Override
    public int deletePrescriptionItemById(int prescriptionItemId) {
        Map<String, Object> params = new HashMap<>();
        params.put("prescriptionItemId", prescriptionItemId);
        return jdbcTemplate.update(PrescriptionItemQuery.DELETE_PRESCRIPTION_ITEM_BY_ID, params);
    }

    @Override
    public List<PrescriptionItemResponse> getPrescriptionItemsByAppointmentId(int appointmentId) {
        Map<String, Object> params = new HashMap<>();
        params.put("appointmentId", appointmentId);
        return jdbcTemplate.query(
                PrescriptionItemQuery.GET_PRESCRIPTION_ITEMS_BY_APPOINTMENT_ID,
                params,
                new PrescriptionItemResponseRowMapper()
        );
    }
}
