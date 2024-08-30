package com.example.stagecochess.Repository;

import com.example.stagecochess.Entities.Form;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FormRepository extends CrudRepository<Form,Long> {
}
