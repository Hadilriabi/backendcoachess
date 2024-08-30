package com.example.stagecochess.Repository;

import com.example.stagecochess.Entities.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface MessageRepository extends CrudRepository<Message,Long> {
}
