package com.example.publisher.controller;

import com.example.publisher.service.NotificationService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

  private final NotificationService notificationService;


    public MessageController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping ("/notifications")
    public String sendStudentNotification(@RequestParam Long studentId){
        notificationService.sendStudentNotification(studentId);
        return "Wiadomość została wyslana do studenta o id: "+ studentId;
    }
}
