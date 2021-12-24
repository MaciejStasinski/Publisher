package com.example.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    private final RabbitTemplate rabbitTemplate;

    public MessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping ("/notification")
    public String sendNotification(@RequestBody Notification notification){
        rabbitTemplate.convertAndSend("Kurs",notification);
        return "Notyfikacja wysłana!";
    }
}
