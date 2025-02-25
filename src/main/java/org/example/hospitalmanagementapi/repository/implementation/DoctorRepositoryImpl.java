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
    public Doctor getDoctorById(int doctorId, int doctorStaffId) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("doctorId", doctorId)
                .addValue("doctorStaffId", doctorStaffId);

        return jdbcTemplate.queryForObject(DoctorQuery.GET_DOCTOR_BY_ID, params, new DoctorRowMapper());
    }


    @Override
    public int createDoctor(Doctor doctor) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("doctorStaffId", doctor.getDoctorStaffId())  // Links doctor to hospital staff
                .addValue("doctorName", doctor.getDoctorName())
                .addValue("doctorSpeciality", doctor.getDoctorSpeciality())
                .addValue("doctorLicenseNumber", doctor.getDoctorLicenseNumber())
                .addValue("doctorYearsExperience", doctor.getDoctorYearsExperience());

        return jdbcTemplate.update(DoctorQuery.INSERT_DOCTOR, params);
    }

    @Override
    public int updateDoctor(int doctorId, int doctorStaffId, Doctor doctor) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("doctorId", doctorId)
                .addValue("doctorStaffId", doctorStaffId)  // Ensures the doctor belongs to the requesting hospital
                .addValue("doctorName", doctor.getDoctorName())
                .addValue("doctorSpeciality", doctor.getDoctorSpeciality())
                .addValue("doctorLicenseNumber", doctor.getDoctorLicenseNumber())
                .addValue("doctorYearsExperience", doctor.getDoctorYearsExperience());

        return jdbcTemplate.update(DoctorQuery.UPDATE_DOCTOR_BY_ID, params);
    }

    @Override
    public int deleteDoctorById(int doctorId, int doctorStaffId) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("doctorId", doctorId)
                .addValue("doctorStaffId", doctorStaffId);  // Ensures deletion is restricted to the same hospital

        return jdbcTemplate.update(DoctorQuery.DELETE_DOCTOR_BY_ID, params);
    }
}
