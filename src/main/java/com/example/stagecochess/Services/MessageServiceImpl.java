package com.example.stagecochess.Services;

import com.example.stagecochess.Entities.Message;
import com.example.stagecochess.Interfaces.MessageService;
import com.example.stagecochess.Repository.MessageRepository;
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
public class MessageServiceImpl implements MessageService {
    MessageRepository messageRepository;
    @Override
    public List<Message> retrieveAllMessages() {
        return (List<Message>) messageRepository.findAll();

    }

    @Override
    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message updateMessage(long idMessage, Message message) {
        Message existingMessage = messageRepository.findById(idMessage).orElse(null);
        if (existingMessage != null) {
            message.setMessageId(idMessage);
            return messageRepository.save(message);
        }
        return null;
    }

    @Override
    public Message retrieveMessage(long idMessage) {
        return messageRepository.findById(idMessage).orElse(null);
    }

    @Override
    public void removeMessage(long idMessage) {
        messageRepository.deleteById(idMessage);

    }}
