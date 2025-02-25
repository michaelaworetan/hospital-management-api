package org.example.hospitalmanagementapi.repository.implementation;

import org.example.hospitalmanagementapi.mapper.HospitalRowMapper;
import org.example.hospitalmanagementapi.model.entity.Hospital;
import org.example.hospitalmanagementapi.repository.Interface.HospitalRepository;
import org.example.hospitalmanagementapi.repository.query.HospitalQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HospitalRespositoryImpl implements HospitalRepository {

    public final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public HospitalRespositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return jdbcTemplate.query(HospitalQuery.GET_ALL, new HospitalRowMapper());
    }

    @Override
    public Hospital getHospitalById(int hospitalId) {
        MapSqlParameterSource params = new MapSqlParameterSource("hospitalId", hospitalId);
        return jdbcTemplate.queryForObject(HospitalQuery.GET_BY_ID, params, new HospitalRowMapper());
    }

    @Override
    public int createHospital(Hospital hospital) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("hospitalName", hospital.getHospitalName())
                .addValue("hospitalEmail", hospital.getHospitalEmail())
                .addValue("hospitalAddress", hospital.getHospitalAddress())
                .addValue("hospitalContactNo", hospital.getHospitalContactNo())
                .addValue("hospitalStatus", hospital.getHospitalStatus());

        return jdbcTemplate.update(HospitalQuery.INSERT_HOSPITAL, params);
    }

    @Override
    public int updateHospital(Hospital hospital) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("hospitalId", hospital.getHospitalId())
                .addValue("hospitalName", hospital.getHospitalName())
                .addValue("hospitalEmail", hospital.getHospitalEmail())
                .addValue("hospitalAddress", hospital.getHospitalAddress())
                .addValue("hospitalContactNo", hospital.getHospitalContactNo())
                .addValue("hospitalStatus", hospital.getHospitalStatus())
                .addValue("hospitalUpdatedAt", hospital.getHospitalUpdatedAt());

        return jdbcTemplate.update(HospitalQuery.UPDATE_HOSPITAL_BY_ID, params);
    }

    @Override
    public int deleteHospitalById(int hospitalId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("hospitalId", hospitalId);

        return jdbcTemplate.update(HospitalQuery.DELETE_HOSPITAL_BY_ID, params);
    }
}
