package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Doctor;
import org.example.hospitalmanagementapi.model.request.DoctorCreateRequest;
import org.example.hospitalmanagementapi.model.request.DoctorUpdateRequest;
import org.example.hospitalmanagementapi.repository.Interface.DoctorRepository;
import org.example.hospitalmanagementapi.repository.Interface.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final HospitalRepository hospitalRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, HospitalRepository hospitalRepository) {
        this.doctorRepository = doctorRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public List<Doctor> getDoctorsByHospitalId(int hospitalId) {
        return doctorRepository.getDoctorsByHospitalId(hospitalId);
    }

    public Doctor getDoctorById(int doctorId, int hospitalId) {
        return doctorRepository.getDoctorById(doctorId, hospitalId);
    }

    public int createDoctor(DoctorCreateRequest request) {
        Gson gson = new Gson();

        // Validate that the hospital exists before creating doctor
        var hospital = hospitalRepository.getHospitalById(request.getDoctorStaffId());
        if (hospital == null) {
            return -1;
        }

        var doctor = gson.fromJson(gson.toJson(request), Doctor.class);
        return doctorRepository.createDoctor(doctor);
    }

    public int updateDoctor(int doctorId, int hospitalId, DoctorUpdateRequest request) {
        Gson gson = new Gson();

        // Validate that the hospital exists before updating doctor
        var hospital = hospitalRepository.getHospitalById(hospitalId);
        if (hospital == null) {
            return -1;
        }

        var doctor = gson.fromJson(gson.toJson(request), Doctor.class);

        doctor.setDoctorId(doctorId);

        return doctorRepository.updateDoctor(doctor, hospitalId);
    }

    public int deleteDoctorById(int doctorId, int hospitalId) {
        return doctorRepository.deleteDoctorById(doctorId, hospitalId);
    }
}
