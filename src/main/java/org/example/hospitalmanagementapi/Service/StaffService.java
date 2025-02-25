package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Staff;
import org.example.hospitalmanagementapi.model.request.StaffCreateRequest;
import org.example.hospitalmanagementapi.model.response.StaffCreateResponse;
import org.example.hospitalmanagementapi.model.response.StaffGetByIdResponse;
import org.example.hospitalmanagementapi.repository.Interface.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    // Get all staff members for a specific hospital
    public List<StaffGetByIdResponse> getStaffByHospitalId(int hospitalId) {
        return staffRepository.getStaffByHospitalId(hospitalId).stream()
                .map(staff -> StaffGetByIdResponse.builder()
                        .staffId(staff.getStaffId())
                        .staffHospitalId(staff.getStaffHospitalId())
                        .staffPosition(staff.getStaffPosition())
                        .staffDepartment(staff.getStaffDepartment())
                        .staffSalary(staff.getStaffSalary())
                        .staffStatus(staff.getStaffStatus())
                        .staffCreatedAt(staff.getStaffCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }

    // Get a specific staff member by ID
    public StaffGetByIdResponse getStaffById(int staffId, int hospitalId) {
        Staff existingStaff = staffRepository.getStaffById(staffId, hospitalId);

        if (existingStaff != null) {
            return StaffGetByIdResponse.builder()
                    .staffId(existingStaff.getStaffId())
                    .staffHospitalId(existingStaff.getStaffHospitalId())
                    .staffPosition(existingStaff.getStaffPosition())
                    .staffDepartment(existingStaff.getStaffDepartment())
                    .staffSalary(existingStaff.getStaffSalary())
                    .staffStatus(existingStaff.getStaffStatus())
                    .staffCreatedAt(existingStaff.getStaffCreatedAt())
                    .build();
        }
        return null;
    }

    // Create a new staff member
    public StaffCreateResponse createStaff(StaffCreateRequest request) {
        Gson gson = new Gson();

        // Convert CreateRequest DTO to Staff entity
        var staff = gson.fromJson(gson.toJson(request), Staff.class);

        // Insert the staff member and get the generated ID
        int staffId = staffRepository.createStaff(staff);

        if (staffId < 1) {
            return null; // Return null if creation failed
        }

        // Convert back to response DTO
        return StaffCreateResponse.builder()
                .staffId(staffId)
                .staffHospitalId(staff.getStaffHospitalId())
                .staffPosition(staff.getStaffPosition())
                .staffDepartment(staff.getStaffDepartment())
                .staffSalary(staff.getStaffSalary())
                .staffStatus(staff.getStaffStatus())
                .staffCreatedAt(staff.getStaffCreatedAt())
                .build();
    }

    // Update staff details
    public int updateStaff(int staffId, int hospitalId, StaffCreateRequest request) {
        Staff existingStaff = staffRepository.getStaffById(staffId, hospitalId);

        if (existingStaff != null) {
            // Map the update request fields to the existing staff entity
            existingStaff.setStaffPosition(request.getStaffPosition());
            existingStaff.setStaffDepartment(request.getStaffDepartment());
            existingStaff.setStaffSalary(request.getStaffSalary());
            existingStaff.setStaffStatus(request.getStaffStatus());
            existingStaff.setStaffUpdatedAt("GETDATE()");

            // Perform the update operation
            return staffRepository.updateStaff(staffId, hospitalId, existingStaff);
        }
        return 0; // Returns 0 if staff member is not found
    }

    // Delete a staff member by ID
    public int deleteStaffById(int staffId, int hospitalId) {
        return staffRepository.deleteStaffById(staffId, hospitalId);
    }
}
