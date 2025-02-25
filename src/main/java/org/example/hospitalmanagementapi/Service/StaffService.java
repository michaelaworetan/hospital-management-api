package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Staff;
import org.example.hospitalmanagementapi.model.request.StaffCreateRequest;
import org.example.hospitalmanagementapi.model.request.StaffUpdateRequest;
import org.example.hospitalmanagementapi.repository.Interface.HospitalRepository;
import org.example.hospitalmanagementapi.repository.Interface.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    private final StaffRepository staffRepository;
    private final HospitalRepository hospitalRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository, HospitalRepository hospitalRepository) {
        this.staffRepository = staffRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public List<Staff> getStaffByHospitalId(int hospitalId) {
        return staffRepository.getStaffByHospitalId(hospitalId);
    }

    public Staff getStaffById(int staffId, int hospitalId) {
        return staffRepository.getStaffById(staffId, hospitalId);
    }

    public int createStaff(StaffCreateRequest request) {
        Gson gson = new Gson();

        // Validate that the hospital exists before creating staff
        var hospital = hospitalRepository.getHospitalById(request.getStaffHospitalId());
        if (hospital == null) {
            return -1;
        }

        var staff = gson.fromJson(gson.toJson(request), Staff.class);
        return staffRepository.createStaff(request);
    }

    public int updateStaff(int staffId, int hospitalId, StaffUpdateRequest request) {
        Gson gson = new Gson();

        // Validate that the hospital exists before updating staff
        var hospital = hospitalRepository.getHospitalById(hospitalId);
        if (hospital == null) {
            return -1;
        }

        var staff = gson.fromJson(gson.toJson(request), Staff.class);
        return staffRepository.updateStaff(staffId, hospitalId, request);
    }

    public int deleteStaffById(int staffId, int hospitalId) {
        return staffRepository.deleteStaffById(staffId, hospitalId);
    }
}
