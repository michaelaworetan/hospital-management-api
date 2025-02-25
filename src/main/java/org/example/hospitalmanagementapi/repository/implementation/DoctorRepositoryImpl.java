package org.example.hospitalmanagementapi.repository.implementation;

import org.example.hospitalmanagementapi.mapper.DoctorRowMapper;
import org.example.hospitalmanagementapi.model.entity.Doctor;
import org.example.hospitalmanagementapi.repository.Interface.DoctorRepository;
import org.example.hospitalmanagementapi.repository.query.DoctorQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorRepositoryImpl implements DoctorRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public DoctorRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createDoctor(Doctor doctor) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("doctorStaffId", doctor.getDoctorStaffId())
                .addValue("doctorSpeciality", doctor.getDoctorSpeciality())
                .addValue("doctorLicenseNumber", doctor.getDoctorLicenseNumber())
                .addValue("doctorYearsExperience", doctor.getDoctorYearsExperience());
        return jdbcTemplate.update(DoctorQuery.INSERT_DOCTOR, params);
    }

    @Override
    public Doctor getDoctorById(int doctorId, int hospitalId) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("doctorId", doctorId)
                .addValue("hospitalId", hospitalId);
        return jdbcTemplate.queryForObject(DoctorQuery.GET_DOCTOR_BY_ID, params, new DoctorRowMapper());
    }

    @Override
    public List<Doctor> getDoctorsByHospitalId(int hospitalId) {
        MapSqlParameterSource params = new MapSqlParameterSource("hospitalId", hospitalId);
        return jdbcTemplate.query(DoctorQuery.GET_DOCTORS_BY_HOSPITAL_ID, params, new DoctorRowMapper());
    }

    @Override
    public int updateDoctor(Doctor doctor, int hospitalId) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("doctorId", doctor.getDoctorId())
                .addValue("hospitalId", hospitalId)
                .addValue("doctorSpeciality", doctor.getDoctorSpeciality())
                .addValue("doctorLicenseNumber", doctor.getDoctorLicenseNumber())
                .addValue("doctorYearsExperience", doctor.getDoctorYearsExperience())
                .addValue("doctorStatus", doctor.getDoctorStatus());
        return jdbcTemplate.update(DoctorQuery.UPDATE_DOCTOR_BY_ID, params);
    }

    @Override
    public int deleteDoctorById(int doctorId, int hospitalId) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("doctorId", doctorId)
                .addValue("hospitalId", hospitalId);
        return jdbcTemplate.update(DoctorQuery.DELETE_DOCTOR_BY_ID, params);
    }
}
