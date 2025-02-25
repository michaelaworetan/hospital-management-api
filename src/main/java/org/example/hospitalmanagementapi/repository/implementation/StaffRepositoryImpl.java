package org.example.hospitalmanagementapi.repository.implementation;

import org.example.hospitalmanagementapi.mapper.StaffRowMapper;
import org.example.hospitalmanagementapi.model.entity.Staff;
import org.example.hospitalmanagementapi.repository.Interface.StaffRepository;
import org.example.hospitalmanagementapi.repository.query.StaffQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffRepositoryImpl implements StaffRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public StaffRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Staff> getStaffByHospitalId(int hospitalId) {
        MapSqlParameterSource params = new MapSqlParameterSource("staffHospitalId", hospitalId);
        return jdbcTemplate.query(StaffQuery.GET_BY_HOSPITAL_ID, params, new StaffRowMapper());
    }

    @Override
    public Staff getStaffById(int staffId, int hospitalId) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("staffId", staffId)
                .addValue("staffHospitalId", hospitalId);
        return jdbcTemplate.queryForObject(StaffQuery.GET_BY_ID, params, new StaffRowMapper());
    }

    @Override
    public int createStaff(Staff staff) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("staffHospitalId", staff.getStaffHospitalId())
                .addValue("staffPosition", staff.getStaffPosition())
                .addValue("staffDepartment", staff.getStaffDepartment())
                .addValue("staffSalary", staff.getStaffSalary());

        return jdbcTemplate.update(StaffQuery.INSERT_STAFF, params);
    }

    @Override
    public int updateStaff(int staffId, int hospitalId, Staff staff) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("staffId", staffId)
                .addValue("staffHospitalId", hospitalId)
                .addValue("staffPosition", staff.getStaffPosition())
                .addValue("staffDepartment", staff.getStaffDepartment())
                .addValue("staffSalary", staff.getStaffSalary());

        return jdbcTemplate.update(StaffQuery.UPDATE_STAFF_BY_ID, params);
    }

    @Override
    public int deleteStaffById(int staffId, int hospitalId) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("staffId", staffId)
                .addValue("staffHospitalId", hospitalId);

        return jdbcTemplate.update(StaffQuery.DELETE_STAFF_BY_ID, params);
    }
}
