package com.example.stagecochess.Controllers;


import com.example.stagecochess.Entities.Form;
import com.example.stagecochess.Entities.Post;
import com.example.stagecochess.Interfaces.FormService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/forms")
public class FormController {
    FormService formService;

    @PostMapping("/addForm")
    public Form addForm(@RequestBody Form form) {
        log.info("Received form: {}", form);
        Form savedForm = formService.addForm(form);
        log.info("Saved form: {}", savedForm);
        return savedForm;
    }

    @PutMapping("/updateForm/{idForm}")
    public Form updateForm(@PathVariable("idForm") long idForm, @RequestBody Form form) {
        return formService.updateForm(idForm, form);
    }

    @GetMapping("/retrieveForm/{idForm}")
    public Form retrieveForm(@PathVariable("idForm") long idForm) {
        return formService.retrieveForm(idForm);
    }

    @DeleteMapping("/removeForm/{idForm}")
    public void removeForm(@PathVariable("idForm") long idForm) {
        formService.removeForm(idForm);
    }

    @GetMapping("/retrieveAllForms")
    public List<Form> retrieveAllForms() {
        return formService.retrieveAllForms();
    }

    @PostMapping("/{FormId}/assignUserToForm/{userId}")
    public ResponseEntity<Form> assignUserToForm(@PathVariable Long FormId, @PathVariable Long userId) {
        Form updatedForm = formService.assignUserToForm(FormId, userId);
        return ResponseEntity.ok(updatedForm);
    }


}
