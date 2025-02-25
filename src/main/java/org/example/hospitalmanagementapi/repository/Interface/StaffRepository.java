package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Staff;

import java.util.List;

public interface StaffRepository {

    //  Get all staff members for a specific hospital
    List<Staff> getStaffByHospitalId(int hospitalId);

    // Get a specific staff member by ID
    Staff getStaffById(int staffId, int hospitalId);

    // Create a new staff member
    int createStaff(Staff staff);

    // Update staff details
    int updateStaff(int staffId, int hospitalId, Staff staff);

    // delete a staff member
    int deleteStaffById(int staffId, int hospitalId);
}
