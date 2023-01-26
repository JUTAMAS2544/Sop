package com.example.userservice.query.controller;

import com.example.userservice.data.User;
import com.example.userservice.query.query.LogInQuery;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*")
public class UserQueryController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/login")
    public User getProfile(@RequestBody LogInQuery query){
        Object model = rabbitTemplate.convertSendAndReceive("UserExchange", "read", query);
        return ((User) model);
    }

    @GetMapping("/all")
    public List<User> getAllProfile(){
        Object model = rabbitTemplate.convertSendAndReceive("UserExchange", "all", "");
        return ((List<User>) model);
    }
}
