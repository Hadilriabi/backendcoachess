package com.example.stagecochess.Services;

import com.example.stagecochess.Entities.Cmtr;
import com.example.stagecochess.Entities.Form;
import com.example.stagecochess.Entities.Post;
import com.example.stagecochess.Entities.User;
import com.example.stagecochess.Interfaces.FormService;
import com.example.stagecochess.Repository.FormRepository;
import com.example.stagecochess.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FormServiceImpl implements FormService {
    FormRepository formRepository;
    UserRepository userRepository;
    @Override
    public List<Form> retrieveAllForms() {
        return (List<Form>) formRepository.findAll();

    }

    @Override
    public Form addForm(Form form) {
        return formRepository.save(form);
    }

    @Override
    public Form updateForm(long idForm, Form form) {
        Form existingForm = formRepository.findById(idForm).orElse(null);
        if (existingForm != null) {
            form.setFormId(idForm);
            return formRepository.save(form);
        }
        return null;
    }

    @Override
    public Form retrieveForm(long idForm) {
        return formRepository.findById(idForm).orElse(null);
    }

    @Override
    public void removeForm(long idForm) {
        formRepository.deleteById(idForm);

    }

    @Transactional

    public Form assignUserToForm(Long formId, Long userId) {
        // Trouver le form par son ID
        Form form = formRepository.findById(formId).orElseThrow(() -> new RuntimeException("form not found"));

        // Trouver l'utilisateur par son ID
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Assigner l'utilisateur au form
        form.setUser(user);

        // Sauvegarder le form avec l'utilisateur assigné
        return formRepository.save(form);
    }







}
