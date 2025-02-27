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
    public List<Staff> getAllStaff() {
        return jdbcTemplate.query(StaffQuery.GET_ALL_STAFF, new StaffRowMapper());
    }

    @Override
    public Staff getStaffById(int staffId) {
        MapSqlParameterSource params = new MapSqlParameterSource("staffId", staffId);
        return jdbcTemplate.queryForObject(StaffQuery.GET_STAFF_BY_ID, params, new StaffRowMapper());
    }

    @Override
    public List<Staff> getAllStaffByHospitalId(int staffHospitalId) {
        MapSqlParameterSource params = new MapSqlParameterSource("staffHospitalId", staffHospitalId);
        return jdbcTemplate.query(StaffQuery.GET_ALL_STAFF_BY_HOSPITAL_ID, params, new StaffRowMapper());
    }

    @Override
    public int createStaff(Staff staff) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("staffHospitalId", staff.getStaffHospitalId())
                .addValue("staffName", staff.getStaffName())
                .addValue("staffPosition", staff.getStaffPosition())
                .addValue("staffDepartment", staff.getStaffDepartment())
                .addValue("staffSalary", staff.getStaffSalary());
        return jdbcTemplate.update(StaffQuery.INSERT_STAFF, params);
    }

    @Override
    public int updateStaff(Staff staff) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("staffId", staff.getStaffId())
                .addValue("staffHospitalId", staff.getStaffHospitalId())
                .addValue("staffName", staff.getStaffName())
                .addValue("staffPosition", staff.getStaffPosition())
                .addValue("staffDepartment", staff.getStaffDepartment())
                .addValue("staffSalary", staff.getStaffSalary())
                .addValue("staffStatus", staff.getStaffStatus());
        return jdbcTemplate.update(StaffQuery.UPDATE_STAFF, params);
    }

    @Override
    public int deleteStaffById(int staffId) {
        MapSqlParameterSource params = new MapSqlParameterSource("staffId", staffId);
        return jdbcTemplate.update(StaffQuery.DELETE_STAFF_BY_ID, params);
    }

    @Override
    public List<Staff> getStaffBySalaryRange(double minSalary, double maxSalary) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("minSalary", minSalary)
                .addValue("maxSalary", maxSalary);

        return jdbcTemplate.query(StaffQuery.GET_STAFF_BY_SALARY_RANGE, params, new StaffRowMapper());
    }
}
