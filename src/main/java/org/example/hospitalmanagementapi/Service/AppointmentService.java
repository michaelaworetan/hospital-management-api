package org.example.hospitalmanagementapi.Service;

import com.google.gson.Gson;
import org.example.hospitalmanagementapi.model.entity.Appointment;
import org.example.hospitalmanagementapi.model.request.AppointmentCreateRequest;
import org.example.hospitalmanagementapi.model.request.AppointmentDateUpdateRequest;
import org.example.hospitalmanagementapi.model.request.AppointmentUpdateRequest;
import org.example.hospitalmanagementapi.model.response.AppointmentResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.AppointmentListResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.AppointmentSingleResponse;
import org.example.hospitalmanagementapi.model.response.serviceresponse.BaseResponse;
import org.example.hospitalmanagementapi.repository.Interface.AppointmentRepository;
import org.example.hospitalmanagementapi.repository.Interface.DoctorRepository;
import org.example.hospitalmanagementapi.repository.Interface.PatientRepository;
import org.example.hospitalmanagementapi.utility.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    private final PatientRepository patientRepository;

    private final DoctorRepository doctorRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository , DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public AppointmentListResponse getAllAppointments() {
        var appointments =  appointmentRepository.getAllAppointments();
        return AppointmentListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .appointments(appointments)
                .build();
    }

    public AppointmentSingleResponse getAppointmentById(int appointmentId) {
        var appointment =  appointmentRepository.getAppointmentById(appointmentId);
        return AppointmentSingleResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .appointment(appointment)
                .build();
    }

    public BaseResponse createAppointment(AppointmentCreateRequest request) {
        Gson gson = new Gson();
        var patient = patientRepository.getPatientById(request.getAppointmentPatientId());
        var doctor = doctorRepository.getDoctorById(request.getAppointmentDoctorId());
        if (patient == null) {
            return new BaseResponse("106", "Patient not found");
        }
        if(doctor == null){
            return new BaseResponse("106", "Doctor not found");
        }
        var appointment = gson.fromJson(gson.toJson(request), Appointment.class);
        appointmentRepository.createAppointment(appointment);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse updateAppointment(AppointmentUpdateRequest request) {
        Gson gson = new Gson();
        var appointmentToBeValidated = appointmentRepository.getAppointmentById(request.getAppointmentId());
        var patient = patientRepository.getPatientById(request.getAppointmentPatientId());
        var doctor = doctorRepository.getDoctorById(request.getAppointmentDoctorId());
        if (patient == null) {
            return new BaseResponse("106", "Patient not found");
        }
        if(doctor == null){
            return new BaseResponse("106", "Doctor not found");
        }
        if(appointmentToBeValidated == null){
            return new BaseResponse("106", "Appointment not found");
        }
        var appointment = gson.fromJson(gson.toJson(request), Appointment.class);
        appointmentRepository.updateAppointment(appointment);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse updateAppointmentDate(AppointmentDateUpdateRequest request){
        Gson gson = new Gson();
        var appointmentResponse = appointmentRepository.getAppointmentById(request.getAppointmentId());
        if(appointmentResponse == null){
            return new BaseResponse("106", "Appointment not found");
        }
        appointmentResponse.setAppointmentDate(request.getAppointmentDate());
        var appointment = gson.fromJson(gson.toJson(appointmentResponse), Appointment.class);
        appointmentRepository.updateAppointment(appointment);
        return ResponseConstants.SUCCESS;
    }

    public BaseResponse deleteAppointmentById(int appointmentId) {
        appointmentRepository.deleteAppointmentById(appointmentId);
        return ResponseConstants.SUCCESS;
    }

    public AppointmentListResponse getAppointmentsByPatientId(int patientId) {
        var appointments =  appointmentRepository.getAppointmentsByPatientId(patientId);

        return AppointmentListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .appointments(appointments)
                .build();
    }

    public AppointmentListResponse getAppointmentsByDoctorId(int doctorId) {
        var appointments =  appointmentRepository.getAppointmentsByDoctorId(doctorId);

        return AppointmentListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .appointments(appointments)
                .build();
    }

    public AppointmentListResponse getAppointmentsByHospitalId(int hospitalId) {
        var appointments =  appointmentRepository.getAppointmentsByHospitalId(hospitalId);

        return AppointmentListResponse.builder()
                .responseCode("00")
                .responseMessage("Successful")
                .appointments(appointments)
                .build();
    }
}
