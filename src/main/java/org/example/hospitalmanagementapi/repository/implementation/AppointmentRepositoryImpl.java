package org.example.hospitalmanagementapi.repository.implementation;

import org.example.hospitalmanagementapi.mapper.AppointmentRowMapper;
import org.example.hospitalmanagementapi.model.entity.Appointment;
import org.example.hospitalmanagementapi.repository.Interface.AppointmentRepository;
import org.example.hospitalmanagementapi.repository.query.AppointmentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public AppointmentRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return jdbcTemplate.query(AppointmentQuery.GET_ALL_APPOINTMENTS, new AppointmentRowMapper());
    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        MapSqlParameterSource params = new MapSqlParameterSource("appointmentId", appointmentId);
        return jdbcTemplate.queryForObject(AppointmentQuery.GET_APPOINTMENT_BY_ID, params, new AppointmentRowMapper());
    }

    @Override
    public int createAppointment(Appointment appointment) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("appointmentDate", appointment.getAppointmentDate())
                .addValue("appointmentPatientId", appointment.getAppointmentPatientId())
                .addValue("appointmentDoctorId", appointment.getAppointmentDoctorId());
        return jdbcTemplate.update(AppointmentQuery.INSERT_APPOINTMENT, params);
    }

    @Override
    public int updateAppointment(Appointment appointment) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("appointmentId", appointment.getAppointmentId())
                .addValue("appointmentDate", appointment.getAppointmentDate())
                .addValue("appointmentPatientId", appointment.getAppointmentPatientId())
                .addValue("appointmentDoctorId", appointment.getAppointmentDoctorId())
                .addValue("appointmentStatus", appointment.getAppointmentStatus());
        return jdbcTemplate.update(AppointmentQuery.UPDATE_APPOINTMENT, params);
    }

    @Override
    public int deleteAppointmentById(int appointmentId) {
        MapSqlParameterSource params = new MapSqlParameterSource("appointmentId", appointmentId);
        return jdbcTemplate.update(AppointmentQuery.DELETE_APPOINTMENT_BY_ID, params);
    }
}