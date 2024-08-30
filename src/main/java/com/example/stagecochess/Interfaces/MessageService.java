package com.example.stagecochess.Interfaces;

import com.example.stagecochess.Entities.Message;

import java.util.List;

public interface MessageService {
    List<Message> retrieveAllMessages();

    Message addMessage(Message message);

    Message updateMessage(long idMessage, Message message);

    Message retrieveMessage(long idMessage);

    void removeMessage(long idMessage);
}
