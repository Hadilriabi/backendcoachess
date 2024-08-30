package com.example.stagecochess.Controllers;


import com.example.stagecochess.Entities.Message;
import com.example.stagecochess.Interfaces.MessageService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/messages")
public class MessageController {

    MessageService messageService;
    @PostMapping("/addMessage")
    public Message addMessage(@RequestBody Message message) {
        return messageService.addMessage(message);
    }

    @PutMapping("/updateMessage/{idMessage}")
    public Message updateMessage(@PathVariable("idMessage") long idMessage, @RequestBody Message message) {
        return messageService.updateMessage(idMessage,message);
    }

    @GetMapping("/retrieveMessage/{idMessage}")
    public  Message retrieveMessage(@PathVariable("idMessage") long idMessage) {
        return messageService.retrieveMessage(idMessage);
    }
    @DeleteMapping("/removeMessage/{idMessage}")
    public void removeMessage(@PathVariable("idMessage") long idMessage) {
        messageService.removeMessage(idMessage);
    }
    @GetMapping("/retrieveAllMessages")
    public List<Message> retrieveAllMessages() {
        return messageService.retrieveAllMessages();
    }


}

