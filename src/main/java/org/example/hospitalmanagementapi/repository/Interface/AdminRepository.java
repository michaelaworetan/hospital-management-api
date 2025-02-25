package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Admin;

import java.util.List;

public interface AdminRepository {
    List<Admin> getAllAdmins();

    Admin getAdminById(int adminId);

    int createAdmin(Admin admin);

    int updateAdmin(Admin admin);

    int deleteAdminById(int adminId);
}
