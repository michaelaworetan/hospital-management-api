package org.example.hospitalmanagementapi.repository.implementation;

import org.example.hospitalmanagementapi.mapper.AdminRowMapper;
import org.example.hospitalmanagementapi.model.entity.Admin;
import org.example.hospitalmanagementapi.repository.Interface.AdminRepository;
import org.example.hospitalmanagementapi.repository.query.AdminQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public AdminRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return jdbcTemplate.query(AdminQuery.GET_ALL_ADMINS, new AdminRowMapper());
    }

    @Override
    public Admin getAdminById(int adminId) {
        MapSqlParameterSource params = new MapSqlParameterSource("adminId", adminId);
        return jdbcTemplate.queryForObject(AdminQuery.GET_ADMIN_BY_ID, params, new AdminRowMapper());
    }

    @Override
    public int createAdmin(Admin admin) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("adminName", admin.getAdminName())
                .addValue("adminHospitalId", admin.getAdminHospitalId());
        return jdbcTemplate.update(AdminQuery.INSERT_ADMIN, params);
    }

    @Override
    public int updateAdmin(Admin admin) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("adminId", admin.getAdminId())
                .addValue("adminName", admin.getAdminName())
                .addValue("adminHospitalId", admin.getAdminHospitalId())
                .addValue("adminStatus", admin.getAdminStatus());
        return jdbcTemplate.update(AdminQuery.UPDATE_ADMIN, params);
    }

    @Override
    public int deleteAdminById(int adminId) {
        MapSqlParameterSource params = new MapSqlParameterSource("adminId", adminId);
        return jdbcTemplate.update(AdminQuery.DELETE_ADMIN_BY_ID, params);
    }
}
