package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.dto.MessageDTO;
import com.aws.codestar.projecttemplates.model.Message;
import com.aws.codestar.projecttemplates.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageRepository repository;

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Message> getMessages() {
        List<Message> messages = new ArrayList<>();
        for (Message message : repository.findAll()) {
            messages.add(message);
        }
        return messages;
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageDTO postMessage(@RequestBody @Valid MessageDTO messageDTO) {
        Message model = new Message(messageDTO.getTitle(), messageDTO.getDescription());
        model = repository.save(model);
        MessageDTO dto = new MessageDTO();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setDescription(model.getDescription());
        return dto;
    }
}
