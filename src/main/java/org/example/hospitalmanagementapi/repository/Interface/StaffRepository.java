package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Staff;
import org.example.hospitalmanagementapi.model.request.StaffCreateRequest;
import org.example.hospitalmanagementapi.model.request.StaffUpdateRequest;

import java.util.List;

public interface StaffRepository {

    List<Staff> getStaffByHospitalId(int hospitalId);

    Staff getStaffById(int staffId, int hospitalId);

    int createStaff(StaffCreateRequest staffRequest);

    int updateStaff(int staffId, int hospitalId, StaffUpdateRequest staffRequest);

    int deleteStaffById(int staffId, int hospitalId);
}
