package com.example.stagecochess.Services;

import com.example.stagecochess.Entities.ChatMessage;
import com.example.stagecochess.Interfaces.ChatMessageService;
import com.example.stagecochess.Repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Override
    public ChatMessage saveMessage(ChatMessage message) {
        // Ici, vous pouvez ajouter des validations ou des transformations
        return chatMessageRepository.save(message);
    }

    // Implémentez d'autres méthodes définies dans l'interface si nécessaire
}
