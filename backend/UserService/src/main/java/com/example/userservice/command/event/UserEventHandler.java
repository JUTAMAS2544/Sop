package com.example.userservice.command.event;

import com.example.userservice.data.User;
import com.example.userservice.data.UserRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEventHandler {
    @Autowired
    private UserRepository repository;

    @EventHandler
    public void on(UserCreateEvent event){
        User user = new User();
        BeanUtils.copyProperties(event, user);
        repository.save(user);
    }

    @EventHandler
    public void on(UserUpdateEvent event){
        User user = new User();
        user.setUser_id(event.getId());
        user.setEmail(event.getEmail());
        user.setPassword(event.getPassword());
        user.setName(event.getName());
        user.setSurname(event.getSurname());
        user.setRole(event.getRole());
        user.setRest_id(event.getRest_id());
        repository.save(user);
    }
}
