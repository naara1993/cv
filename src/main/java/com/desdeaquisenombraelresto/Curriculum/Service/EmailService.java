package com.desdeaquisenombraelresto.Curriculum.Service;

import com.desdeaquisenombraelresto.Curriculum.Model.ContactMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final String receiverEmail;
    private final String fromEmail;

    @Autowired
    public EmailService(
            JavaMailSender mailSender,
            @Value("${spring.mail.username:naaracataldo@gmail.com}") String fromEmail,
            @Value("${contact.receiver.email:naaracataldo@gmail.com}") String receiverEmail
    ) {
        this.mailSender = mailSender;
        this.fromEmail = fromEmail;
        this.receiverEmail = receiverEmail;

        System.out.println("EmailService configurado:");
        System.out.println(" - From: " + this.fromEmail);
        System.out.println(" - To: " + this.receiverEmail);
    }

    public void sendContactNotification(ContactMessage message) {
        try {
            SimpleMailMessage email = new SimpleMailMessage();
            email.setFrom(this.fromEmail);
            email.setTo(this.receiverEmail);
            email.setSubject("Nuevo mensaje de contacto de " + message.getNombre());

            String emailBody = "Tienes un nuevo mensaje de contacto:\n\n" +
                    "Nombre: " + message.getNombre() + "\n" +
                    "Email: " + message.getEmail() + "\n" +
                    "Fecha: " + message.getFecha() + "\n\n" +
                    "Mensaje:\n" + message.getMensaje() + "\n\n" +
                    "Responde pronto!";

            email.setText(emailBody);

            mailSender.send(email);
            System.out.println("Email enviado correctamente a: " + this.receiverEmail);

        } catch (Exception e) {
            System.err.println("Error enviando email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}