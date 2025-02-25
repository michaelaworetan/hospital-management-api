package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Admin;
import org.example.hospitalmanagementapi.model.request.AdminCreateRequest;
import org.example.hospitalmanagementapi.model.request.AdminUpdateRequest;
import org.example.hospitalmanagementapi.repository.Interface.AdminRepository;
import org.example.hospitalmanagementapi.repository.Interface.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

//    private final HospitalRepository hospitalRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository /*, HospitalRepository hospitalRepository*/) {
        this.adminRepository = adminRepository;
//        this.hospitalRepository = hospitalRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.getAllAdmins();
    }

    public Admin getAdminById(int adminId) {
        return adminRepository.getAdminById(adminId);
    }

    public int createAdmin(AdminCreateRequest request) {
        Gson gson = new Gson();
//        var hospital = hospitalRepository.getHospitalById(request.getAdminHospitalId());
//        if (hospital == null) {
//            return -1;
//        }
        var admin = gson.fromJson(gson.toJson(request), Admin.class);
        return adminRepository.createAdmin(admin);
    }

    public int updateAdmin(AdminUpdateRequest request) {
        Gson gson = new Gson();
        //var hospital = hospitalRepository.getHospitalById(request.getHospitalId());
//        if (hospital == null) {
//            return -1;
//        }
        var admin = gson.fromJson(gson.toJson(request), Admin.class);
        return adminRepository.updateAdmin(admin);
    }

    public int deleteAdminById(int adminId) {
        return adminRepository.deleteAdminById(adminId);
    }
}