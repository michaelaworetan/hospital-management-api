package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Doctor;
import org.example.hospitalmanagementapi.model.request.DoctorCreateRequest;
import org.example.hospitalmanagementapi.model.request.DoctorUpdateRequest;
import org.example.hospitalmanagementapi.repository.Interface.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    // private final StaffRepository staffRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository /*, StaffRepository staffRepository */) {
        this.doctorRepository = doctorRepository;
        // this.staffRepository = staffRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.getAllDoctors();
    }

    public Doctor getDoctorById(int doctorId) {
        return doctorRepository.getDoctorById(doctorId);
    }

    public int createDoctor(DoctorCreateRequest request) {
        Gson gson = new Gson();

        // var staff = staffRepository.getStaffById(request.getDoctorStaffId());
        // if (staff == null) {
        //     return -1;
        // }

        var doctor = gson.fromJson(gson.toJson(request), Doctor.class);
        return doctorRepository.createDoctor(doctor);
    }

    public int updateDoctor(DoctorUpdateRequest request) {
        Gson gson = new Gson();

        // var staff = staffRepository.getStaffById(request.getDoctorStaffId());
        // if (staff == null) {
        //     return -1;
        // }

        var doctor = gson.fromJson(gson.toJson(request), Doctor.class);
        return doctorRepository.updateDoctor(doctor);
    }

    public int deleteDoctorById(int doctorId) {
        return doctorRepository.deleteDoctorById(doctorId);
    }
}
