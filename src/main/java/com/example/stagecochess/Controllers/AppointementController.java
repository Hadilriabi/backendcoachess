package com.example.stagecochess.Controllers;

import com.example.stagecochess.Entities.Appointment;
import com.example.stagecochess.Entities.Form;
import com.example.stagecochess.Entities.Post;
import com.example.stagecochess.Interfaces.AppointementService;
import com.example.stagecochess.Interfaces.FormService;
import com.example.stagecochess.Services.EmailService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/appointments")
public class AppointementController {

    AppointementService appointementService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/addAppointment")
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        log.info("Received appointment: {}", appointment);
        Appointment savedAppointement = appointementService.addAppointment(appointment);
        log.info("Saved appointment: {}", savedAppointement);
        return savedAppointement;
    }

    @PutMapping("/updateAppointment/{idAppointment}")
    public Appointment updateAppointment(@PathVariable("idAppointment") long idAppointment, @RequestBody Appointment appointment) {
        return appointementService.updateAppointment(idAppointment, appointment);
    }

    @GetMapping("/retrieveAppointment/{idAppointment}")
    public Appointment retrieveAppointment(@PathVariable("idAppointment") long idAppointment) {
        return appointementService.retrieveAppointment(idAppointment);
    }

    @DeleteMapping("/removeAppointment/{idAppointment}")
    public void removeAppointment(@PathVariable("idAppointment") long idAppointment) {
        appointementService.removeAppointment(idAppointment);
    }

    @GetMapping("/retrieveAllAppointments")
    public List<Appointment> retrieveAllAppointments() {
        return appointementService.retrieveAllAppointments();
    }


    @PostMapping("/{id}/approve")
    public ResponseEntity<Appointment> approveAppointment(@PathVariable("id") long idAppointment) {
        Appointment approvedAppointment = appointementService.approveAppointment(idAppointment);
        if (approvedAppointment != null) {
            return ResponseEntity.ok(approvedAppointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{appointementId}/assignUserToAppointment/{userId}")
    public ResponseEntity<Appointment> assignUserToAppointment(@PathVariable Long appointementId, @PathVariable Long userId) {
        Appointment updatedAppointment = appointementService.assignUserToAppointment(appointementId, userId);
        return ResponseEntity.ok(updatedAppointment);
    }


}