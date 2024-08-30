package com.example.stagecochess.Interfaces;

import com.example.stagecochess.Entities.Appointment;

import java.util.List;

public interface AppointementService {

    List<Appointment> retrieveAllAppointments();

    Appointment addAppointment(Appointment appointment);

    Appointment updateAppointment(long idAppointment, Appointment appointment);

    Appointment retrieveAppointment(long idAppointment);

    void removeAppointment(long idAppointment);

    Appointment approveAppointment(long idAppointment);

    Appointment assignUserToAppointment(Long AppointmentId, Long userId);


}
