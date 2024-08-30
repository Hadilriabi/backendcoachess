package com.example.stagecochess.Interfaces;

import com.example.stagecochess.Entities.Form;

import java.util.List;
import java.util.Map;

public interface FormService {


    List<Form> retrieveAllForms();

    Form addForm(Form form);

    Form updateForm(long idForm, Form form);

    Form retrieveForm(long idForm);

    void removeForm(long idForm);

    Form assignUserToForm(Long formId, Long userId);

}
