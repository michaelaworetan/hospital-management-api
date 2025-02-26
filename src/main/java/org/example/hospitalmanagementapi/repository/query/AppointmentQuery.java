package org.example.hospitalmanagementapi.repository.query;

public class AppointmentQuery {
    public static final String INSERT_APPOINTMENT = """
        INSERT INTO Appointment (appointmentPatientId, appointmentDoctorId, appointmentHospitalId, appointmentDate)
        VALUES (:appointmentPatientId, :appointmentDoctorId, :appointmentHospitalId, :appointmentDate)
        """;

    public static final String GET_ALL_APPOINTMENTS = "SELECT * FROM Appointment WHERE appointmentStatus = 'ACTIVE'";

    public static final String GET_APPOINTMENTS_BY_PATIENT_ID = "SELECT * FROM Appointment WHERE appointmentPatientId = :appointmentPatientId AND appointmentStatus = 'ACTIVE'";

    public static final String GET_APPOINTMENTS_BY_DOCTOR_ID = "SELECT * FROM Appointment WHERE appointmentDoctorId = :appointmentDoctorId AND appointmentStatus = 'ACTIVE'";

    public static final String GET_APPOINTMENTS_BY_HOSPITAL_ID = """
            SELECT a.*, s.staffName AS appointmentDoctorName, p.patientName AS appointmentPatientName FROM Appointment a
            LEFT JOIN Doctor d ON a.appointmentDoctorId = d.doctorId
            LEFT JOIN STAFF s ON d.doctorStaffId = s.staffId
            LEFT JOIN Patient p ON a.appointmentPatientId = p.patientId
            WHERE a.appointmentHospitalId = :appointmentHospitalId AND a.appointmentStatus = 'ACTIVE'
            """;

    public static final String GET_APPOINTMENT_BY_ID = "SELECT * FROM Appointment WHERE appointmentId = :appointmentId AND appointmentStatus = 'ACTIVE'";

    public static final String UPDATE_APPOINTMENT = """
        UPDATE Appointment
        SET appointmentPatientId = :appointmentPatientId,
            appointmentDoctorId = :appointmentDoctorId,
            appointmentHospitalId = :appointmentHospitalId,
            appointmentDate = :appointmentDate,
            appointmentStatus = :appointmentStatus,
            appointmentUpdatedAt = GETDATE()
        WHERE appointmentId = :appointmentId
        """;

    public static final String DELETE_APPOINTMENT_BY_ID = """
        UPDATE Appointment
        SET appointmentStatus = 'DELETED',
            appointmentUpdatedAt = GETDATE()
        WHERE appointmentId = :appointmentId
        """;
}
