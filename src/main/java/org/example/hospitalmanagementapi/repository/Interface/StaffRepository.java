package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Staff;

import java.util.List;

public interface StaffRepository {
    List<Staff> getAllStaff();

    Staff getStaffById(int staffId);

    int createStaff(Staff staff);

    int updateStaff(Staff staff);

    int deleteStaffById(int staffId);
}
