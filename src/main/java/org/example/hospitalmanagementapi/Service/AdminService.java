package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Admin;
import org.example.hospitalmanagementapi.model.request.AdminCreateRequest;
import org.example.hospitalmanagementapi.model.request.AdminUpdateRequest;
import org.example.hospitalmanagementapi.model.response.serviceresponse.AdminListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.AdminSingleResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
import org.example.hospitalmanagementapi.repository.Interface.AdminRepository;
import org.example.hospitalmanagementapi.repository.Interface.HospitalRepository;
import org.example.hospitalmanagementapi.utility.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    private final HospitalRepository hospitalRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository , HospitalRepository hospitalRepository) {
        this.adminRepository = adminRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public AdminListResponse getAllAdmins() {
        var admins = adminRepository.getAllAdmins();
        return AdminListResponse.builder()
                .responseCode("00")
                .responseMessage("SUCCESSFUL")
                .admins(admins)
                .build();
    }

    public AdminSingleResponse getAdminById(int adminId) {
        var admin =  adminRepository.getAdminById(adminId);
        return AdminSingleResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .admin(admin)
                .build();
    }

    public BaseResponse createAdmin(AdminCreateRequest request) {
        Gson gson = new Gson();
        var hospital = hospitalRepository.getHospitalById(request.getAdminHospitalId());
        if (hospital == null) {
            return new BaseResponse("106", "Hospital not found");
        }
        var admin = gson.fromJson(gson.toJson(request), Admin.class);
        adminRepository.createAdmin(admin);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse updateAdmin(AdminUpdateRequest request) {
        Gson gson = new Gson();
        var hospital = hospitalRepository.getHospitalById(request.getAdminHospitalId());
        if (hospital == null) {
            return new BaseResponse("106", "Hospital not found");
        }
        var admin = gson.fromJson(gson.toJson(request), Admin.class);
        adminRepository.updateAdmin(admin);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse deleteAdminById(int adminId) {
        adminRepository.deleteAdminById(adminId);
        return ResponseConstants.SUCCESS;
    }
}