package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Staff;
import org.example.hospitalmanagementapi.model.request.StaffCreateRequest;
import org.example.hospitalmanagementapi.model.request.StaffUpdateRequest;
import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.StaffListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.StaffSingleResponse;
import org.example.hospitalmanagementapi.repository.Interface.HospitalRepository;
import org.example.hospitalmanagementapi.repository.Interface.StaffRepository;
import org.example.hospitalmanagementapi.utility.ResponseConstants;
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

    public StaffListResponse getAllStaff() {
        var staffs = staffRepository.getAllStaff();
        return StaffListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .staffs(staffs)
                .build();
    }

    public StaffSingleResponse getStaffById(int staffId) {
        var staff = staffRepository.getStaffById(staffId);
        return StaffSingleResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .staff(staff)
                .build();
    }

    public StaffListResponse getAllStaffByHospitalId(int staffHospitalId) {
        var hospital = hospitalRepository.getHospitalById(staffHospitalId);
        if (hospital == null) {
            return StaffListResponse.builder()
                    .responseCode("106")
                    .responseMessage("Hospital not found")
                    .staffs(List.of())
                    .build();
        }
        var staffs = staffRepository.getAllStaffByHospitalId(staffHospitalId);
        return StaffListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .staffs(staffs)
                .build();
    }

    public BaseResponse createStaff(StaffCreateRequest request) {
        Gson gson = new Gson();

        var hospital = hospitalRepository.getHospitalById(request.getStaffHospitalId());
        if (hospital == null) {
            return new BaseResponse("106", "Hospital not found");
        }

        var staff = gson.fromJson(gson.toJson(request), Staff.class);
        staffRepository.createStaff(staff);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse updateStaff(StaffUpdateRequest request) {
        Gson gson = new Gson();

        var hospital = hospitalRepository.getHospitalById(request.getStaffHospitalId());
        if (hospital == null) {
            return new BaseResponse("106", "Hospital not found");
        }

        var staff = gson.fromJson(gson.toJson(request), Staff.class);
        staffRepository.updateStaff(staff);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse deleteStaffById(int staffId) {
        staffRepository.deleteStaffById(staffId);
        return ResponseConstants.SUCCESS;
    }

    public StaffListResponse getStaffBySalaryRange(double minSalary, double maxSalary) {
        var staffs = staffRepository.getStaffBySalaryRange(minSalary, maxSalary);

        return StaffListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .staffs(staffs)
                .build();
    }
}
