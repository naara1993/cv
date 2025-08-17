package com.desdeaquisenombraelresto.Curriculum.Service;

import com.desdeaquisenombraelresto.Curriculum.Model.ContactMessage;
import com.desdeaquisenombraelresto.Curriculum.Repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository repository;

    public List<ContactMessage> getAllMessages() {
        return repository.findAll();
    }

    public ContactMessage getMessageById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ContactMessage createMessage(ContactMessage message) {
        return repository.save(message);
    }

    public void deleteMessage(Long id) {
        repository.deleteById(id);
    }

}