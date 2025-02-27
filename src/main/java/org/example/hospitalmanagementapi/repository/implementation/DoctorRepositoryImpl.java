package org.example.hospitalmanagementapi.repository.implementation;

import org.example.hospitalmanagementapi.mapper.DoctorRowMapper;
import org.example.hospitalmanagementapi.mapper.DoctorDetailsRowMapper;
import org.example.hospitalmanagementapi.model.entity.Doctor;
import org.example.hospitalmanagementapi.model.response.DoctorDetailsResponse;
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
    public List<Doctor> getAllDoctors() {
        return jdbcTemplate.query(DoctorQuery.GET_ALL_DOCTORS, new DoctorRowMapper());
    }

    @Override
    public Doctor getDoctorById(int doctorId) {
        MapSqlParameterSource params = new MapSqlParameterSource("doctorId", doctorId);
        return jdbcTemplate.queryForObject(DoctorQuery.GET_DOCTOR_BY_ID, params, new DoctorRowMapper());
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
    public int updateDoctor(Doctor doctor) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("doctorId", doctor.getDoctorId())
                .addValue("doctorStaffId", doctor.getDoctorStaffId())
                .addValue("doctorSpeciality", doctor.getDoctorSpeciality())
                .addValue("doctorLicenseNumber", doctor.getDoctorLicenseNumber())
                .addValue("doctorYearsExperience", doctor.getDoctorYearsExperience())
                .addValue("doctorStatus", doctor.getDoctorStatus());
        return jdbcTemplate.update(DoctorQuery.UPDATE_DOCTOR, params);
    }

    @Override
    public int deleteDoctorByStaffId(int doctorStaffId) { // Updated method
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("doctorStaffId", doctorStaffId);
        return jdbcTemplate.update(DoctorQuery.DELETE_DOCTOR_BY_STAFF_ID, params);
    }

    @Override
    public List<DoctorDetailsResponse> getDoctorDetailsByHospitalId(int hospitalId) {
        MapSqlParameterSource params = new MapSqlParameterSource("hospitalId", hospitalId);
        return jdbcTemplate.query(DoctorQuery.GET_DOCTOR_DETAILS_BY_HOSPITAL_ID, params, new DoctorDetailsRowMapper());
    }
}
