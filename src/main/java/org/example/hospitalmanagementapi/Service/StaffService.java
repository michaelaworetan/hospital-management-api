package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Staff;
import org.example.hospitalmanagementapi.model.request.StaffCreateRequest;
import org.example.hospitalmanagementapi.model.request.StaffUpdateRequest;
import org.example.hospitalmanagementapi.repository.Interface.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    private final StaffRepository staffRepository;
//    private final HospitalRepository hospitalRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository/*,HospitalRepository hospitalRepository*/) {
        this.staffRepository = staffRepository;
//        this.hospitalRepository = hospitalRepository;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.getAllStaff();
    }

    public Staff getStaffById(int staffId) {
        return staffRepository.getStaffById(staffId);
    }

    public int createStaff(StaffCreateRequest request) {
        Gson gson = new Gson();

        // Validate hospital existence
//        var hospital = hospitalRepository.getHospitalById(request.getStaffHospitalId());
//        if (hospital == null) {
//            return -1;
//        }

        var staff = gson.fromJson(gson.toJson(request), Staff.class);
        return staffRepository.createStaff(staff);
    }

    public int updateStaff(StaffUpdateRequest request) {
        Gson gson = new Gson();

        // Validate hospital existence
//        var hospital = hospitalRepository.getHospitalById(request.getStaffHospitalId());
//        if (hospital == null) {
//            return -1;
//        }

        var staff = gson.fromJson(gson.toJson(request), Staff.class);
        return staffRepository.updateStaff(staff);
    }

    public int deleteStaffById(int staffId) {
        return staffRepository.deleteStaffById(staffId);
    }
}
