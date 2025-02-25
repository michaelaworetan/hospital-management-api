package org.example.hospitalmanagementapi.repository.query;

public class AppointmentQuery {
    public static final String INSERT_APPOINTMENT = """
        INSERT INTO Appointment (appointmentPatientId, appointmentDoctorId, appointmentDate)
        VALUES (:appointmentPatientId, :appointmentDoctorId, :appointmentDate)
        """;

    public static final String GET_ALL_APPOINTMENTS = "SELECT * FROM Appointment WHERE appointmentStatus = 'ACTIVE'";

    public static final String GET_APPOINTMENT_BY_ID = "SELECT * FROM Appointment WHERE appointmentId = :appointmentId AND appointmentStatus = 'ACTIVE'";

    public static final String UPDATE_APPOINTMENT = """
        UPDATE Appointment
        SET appointmentPatientId = :appointmentPatientId,
            appointmentDoctorId = :appointmentDoctorId,
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
