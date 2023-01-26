package com.example.userservice.command.controller;

import com.example.userservice.command.model.UserRestModel;
import com.example.userservice.data.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*")
public class UserCommandController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public String createUser(
            @RequestBody UserRestModel model
    )
    {
        Object result = rabbitTemplate.convertSendAndReceive("UserExchange", "create", model);
        return ((String) result);
    }

    @PutMapping
    public String updateUser(
            @RequestBody User model
    ){
        Object result = rabbitTemplate.convertSendAndReceive("UserExchange", "update", model);
        return ((String) result);
    }
}
