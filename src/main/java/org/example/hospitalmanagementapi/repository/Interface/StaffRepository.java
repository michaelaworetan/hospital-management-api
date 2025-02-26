package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Staff;

import java.util.List;

public interface StaffRepository {
    List<Staff> getAllStaff();

    Staff getStaffById(int staffId);

    List<Staff> getAllStaffByHospitalId(int staffHospitalId);

    int createStaff(Staff staff);

    int updateStaff(Staff staff);

    int deleteStaffById(int staffId);

    List<Staff> getStaffBySalaryRange(double minSalary, double maxSalary);
}