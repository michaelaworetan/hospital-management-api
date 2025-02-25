package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Doctor;
import org.example.hospitalmanagementapi.model.request.DoctorCreateRequest;
import org.example.hospitalmanagementapi.model.response.DoctorCreateResponse;
import org.example.hospitalmanagementapi.model.response.DoctorGetByIdResponse;
import org.example.hospitalmanagementapi.repository.Interface.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    // Get a specific doctor by ID
    public DoctorGetByIdResponse getDoctorById(int doctorId, int doctorStaffId) {
        Doctor existingDoctor = doctorRepository.getDoctorById(doctorId, doctorStaffId);

        if (existingDoctor != null) {
            return DoctorGetByIdResponse.builder()
                    .doctorId(existingDoctor.getDoctorId())
                    .doctorStaffId(existingDoctor.getDoctorStaffId())
                    .doctorName(existingDoctor.getDoctorName())
                    .doctorSpeciality(existingDoctor.getDoctorSpeciality())
                    .doctorLicenseNumber(existingDoctor.getDoctorLicenseNumber())
                    .doctorYearsExperience(existingDoctor.getDoctorYearsExperience())
                    .doctorStatus(existingDoctor.getDoctorStatus())
                    .doctorCreatedAt(existingDoctor.getDoctorCreatedAt())
                    .doctorUpdatedAt(existingDoctor.getDoctorUpdatedAt())
                    .build();
        }
        return null;
    }

    // Create a new doctor
    public DoctorCreateResponse createDoctor(DoctorCreateRequest request) {
        Gson gson = new Gson();

        // Convert CreateRequest DTO to Doctor entity
        var doctor = gson.fromJson(gson.toJson(request), Doctor.class);

        // Insert the doctor and get the generated ID
        int doctorId = doctorRepository.createDoctor(doctor);

        if (doctorId < 1) {
            return null; // Return null if creation failed
        }

        // Convert back to response DTO
        return DoctorCreateResponse.builder()
                .doctorId(doctorId)
                .doctorStaffId(doctor.getDoctorStaffId())
                .doctorName(doctor.getDoctorName())
                .doctorSpeciality(doctor.getDoctorSpeciality())
                .doctorLicenseNumber(doctor.getDoctorLicenseNumber())
                .doctorYearsExperience(doctor.getDoctorYearsExperience())
                .doctorStatus(doctor.getDoctorStatus())
                .doctorCreatedAt(doctor.getDoctorCreatedAt()) // Using the same approach as StaffService
                .build();
    }

    // Update doctor details
    public int updateDoctor(int doctorId, int doctorStaffId, DoctorCreateRequest request) {
        Doctor existingDoctor = doctorRepository.getDoctorById(doctorId, doctorStaffId);

        if (existingDoctor != null) {
            // Map the update request fields to the existing doctor entity
            existingDoctor.setDoctorName(request.getDoctorName());
            existingDoctor.setDoctorSpeciality(request.getDoctorSpeciality());
            existingDoctor.setDoctorLicenseNumber(request.getDoctorLicenseNumber());
            existingDoctor.setDoctorYearsExperience(request.getDoctorYearsExperience());
            existingDoctor.setDoctorStatus(request.getDoctorStatus());
            existingDoctor.setDoctorUpdatedAt("GETDATE()"); // Matches StaffService

            // Perform the update operation
            return doctorRepository.updateDoctor(doctorId, doctorStaffId, existingDoctor);
        }
        return 0; // Returns 0 if doctor is not found
    }

    // Delete a doctor by ID
    public int deleteDoctorById(int doctorId, int doctorStaffId) {
        return doctorRepository.deleteDoctorById(doctorId, doctorStaffId);
    }
}
