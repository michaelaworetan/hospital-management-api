package org.example.hospitalmanagementapi.repository.Interface;

import org.example.hospitalmanagementapi.model.entity.Doctor;
import java.util.List;

public interface DoctorRepository {

    //  Get a specific doctor by ID )
    Doctor getDoctorById(int doctorId, int doctorStaffId);


    //  Create a new doctor (Tied to a specific staff in a hospital)
    int createDoctor(Doctor doctor);

    // Update doctor details (Ensures updates only within the same hospital)
    int updateDoctor(int doctorId, int doctorStaffId, Doctor doctor);

    // Delete a doctor by ID (delete restricted to the same hospital)
    int deleteDoctorById(int doctorId, int doctorStaffId);
}
