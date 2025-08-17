package com.desdeaquisenombraelresto.Curriculum.Controller;

import com.desdeaquisenombraelresto.Curriculum.Model.ContactMessage;
import com.desdeaquisenombraelresto.Curriculum.Service.ContactMessageService;
import com.desdeaquisenombraelresto.Curriculum.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactMessageController {

    private final ContactMessageService contactService;
    private final EmailService emailService;

    @Autowired
    public ContactMessageController(ContactMessageService contactService,
                                    EmailService emailService) {
        this.contactService = contactService;
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<ContactMessage> createMessage(@RequestBody ContactMessage message) {
        message.setFecha(LocalDateTime.now());
        ContactMessage savedMessage = contactService.createMessage(message);

        // Enviar notificación por email
        try {
            emailService.sendContactNotification(savedMessage);
        } catch (Exception e) {
            System.err.println("Error enviando email: " + e.getMessage());
        }

        return ResponseEntity.ok(savedMessage);
    }

    @GetMapping
    public List<ContactMessage> getAllMessages() {
        return contactService.getAllMessages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactMessage> getMessageById(@PathVariable Long id) {
        ContactMessage message = contactService.getMessageById(id);
        return message != null ?
                ResponseEntity.ok(message) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        contactService.deleteMessage(id);
    }
}
