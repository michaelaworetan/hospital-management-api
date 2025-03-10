package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Doctor;
import org.example.hospitalmanagementapi.model.entity.Staff;
import org.example.hospitalmanagementapi.model.request.DoctorCreateRequest;
import org.example.hospitalmanagementapi.model.request.DoctorUpdateRequest;
import org.example.hospitalmanagementapi.model.response.DoctorDetailsResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.DoctorDetailsListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.DoctorListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.DoctorSingleResponse;
import org.example.hospitalmanagementapi.repository.Interface.DoctorRepository;
import org.example.hospitalmanagementapi.repository.Interface.StaffRepository;
import org.example.hospitalmanagementapi.utility.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    private final StaffRepository staffRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, StaffRepository staffRepository) {
        this.doctorRepository = doctorRepository;
        this.staffRepository = staffRepository;
    }

    public DoctorListResponse getAllDoctors() {
        var doctors =  doctorRepository.getAllDoctors();

        return DoctorListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .doctors(doctors)
                .build();
    }

    public DoctorSingleResponse getDoctorById(int doctorId) {
        var doctor =  doctorRepository.getDoctorById(doctorId);

        return DoctorSingleResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .doctor(doctor)
                .build();
    }

    public BaseResponse createDoctor(DoctorCreateRequest request) {
        Gson gson = new Gson();

        var staff = gson.fromJson(gson.toJson(request), Staff.class);
        var newlyCreatedStaff = staffRepository.createStaff(staff);
        if (newlyCreatedStaff < 1) {
            return new BaseResponse("106", "Staff not created");
        }

        var doctor = gson.fromJson(gson.toJson(request), Doctor.class);
        doctor.setDoctorStaffId(newlyCreatedStaff);
        doctorRepository.createDoctor(doctor);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse updateDoctor(DoctorUpdateRequest request) {
        Gson gson = new Gson();
        var doctorResponse = doctorRepository.getDoctorById(request.getDoctorId());
        if(doctorResponse == null){
            return new BaseResponse("106", "Doctor not found");
        }

        var staff = staffRepository.getStaffById(request.getDoctorStaffId());
        if (staff == null) {
            return new BaseResponse("106", "Staff not found");
        }

        var doctor = gson.fromJson(gson.toJson(request), Doctor.class);
        doctorRepository.updateDoctor(doctor);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse deleteDoctorByStaffId(int doctorStaffId) { // Updated method
        doctorRepository.deleteDoctorByStaffId(doctorStaffId);
        return ResponseConstants.SUCCESS;
    }

    public DoctorDetailsListResponse getDoctorDetailsByHospitalId(int hospitalId) {

        List<DoctorDetailsResponse> doctorDetails = doctorRepository.getDoctorDetailsByHospitalId(hospitalId);

        return DoctorDetailsListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .detailsResponses(doctorDetails)
                .build();
    }
}
