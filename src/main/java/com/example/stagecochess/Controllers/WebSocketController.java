package com.example.stagecochess.Controllers;

import com.example.stagecochess.Entities.ChatMessage;
import com.example.stagecochess.Interfaces.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @Autowired
    private ChatMessageService chatMessageService; // Injecter le service via l'interface

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessage chat(@DestinationVariable String roomId, ChatMessage message) {
        // Assurez-vous que l'utilisateur est correctement associé
        // Exemple de récupération de l'utilisateur (à adapter selon votre contexte)
        // User user = userService.getCurrentUser(); // À remplacer par la logique réelle

        // Associez l'utilisateur au message si nécessaire
        // message.setUser(user);

        // Sauvegardez le message via le service
        ChatMessage savedMessage = chatMessageService.saveMessage(message);

        // Retournez le message enregistré pour qu'il soit envoyé aux abonnés
        return savedMessage;
    }
}
