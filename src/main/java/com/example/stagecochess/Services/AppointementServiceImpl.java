package com.example.stagecochess.Services;

import com.example.stagecochess.Entities.Appointment;
import com.example.stagecochess.Entities.Post;
import com.example.stagecochess.Entities.User;
import com.example.stagecochess.Interfaces.AppointementService;
import com.example.stagecochess.Repository.AppointmentRepository;
import com.example.stagecochess.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointementServiceImpl implements AppointementService {
    AppointmentRepository appointmentRepository;
    UserRepository userRepository;
    @Override
    public List<Appointment> retrieveAllAppointments() {
        return (List<Appointment>) appointmentRepository.findAll();

    }

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(long idAppointment, Appointment appointment) {
        Appointment existingidAppointment = appointmentRepository.findById(idAppointment).orElse(null);
        if (existingidAppointment != null) {
            appointment.setId(idAppointment);
            return appointmentRepository.save(appointment);
        }
        return null;
    }

    @Override
    public Appointment retrieveAppointment(long idAppointment) {
        return appointmentRepository.findById(idAppointment).orElse(null);
    }

    @Override
    public void removeAppointment(long idAppointment) {
        appointmentRepository.deleteById(idAppointment);

    }

    @Override
    public Appointment approveAppointment(long idAppointment) {
        Appointment existingAppointment = appointmentRepository.findById(idAppointment).orElse(null);
        if (existingAppointment != null) {
            existingAppointment.setIsApproved(true);
            return appointmentRepository.save(existingAppointment);
        }
        return null;
    }

    @Transactional

    public Appointment assignUserToAppointment(Long AppointmentId, Long userId) {
        // Trouver le post par son ID
        Appointment appointment = appointmentRepository.findById(AppointmentId).orElseThrow(() -> new RuntimeException("Post not found"));

        // Trouver l'utilisateur par son ID
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Assigner l'utilisateur au post
        appointment.setUser(user);

        // Sauvegarder le post avec l'utilisateur assigné
        return appointmentRepository.save(appointment);
    }



}
