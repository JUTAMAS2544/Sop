package com.example.userservice.command.service;

import com.example.userservice.command.commands.CreateUserCommand;
import com.example.userservice.command.commands.UpdateUserCommand;
import com.example.userservice.command.model.UserRestModel;
import com.example.userservice.data.User;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserCommandService {
    @Autowired
    private CommandGateway commandGateway;

    @RabbitListener(queues = "CreateUser")
    public String createUser(UserRestModel model)
    {
        String password = encrypt(model.getPassword(), 10);
        CreateUserCommand command = CreateUserCommand
                .builder()
                .user_id(UUID.randomUUID().toString())
                .email(model.getEmail())
                .password(password)
                .name(model.getName())
                .surname(model.getSurname())
                .role("User")
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(command);
        }
        catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @RabbitListener(queues = "UpdateUser")
    public String updateUser(User model){
        String password = encrypt(model.getPassword(), 10);
        UpdateUserCommand command = UpdateUserCommand
                .builder()
                .user_id(UUID.randomUUID().toString())
                .email(model.getEmail())
                .password(password)
                .name(model.getName())
                .surname(model.getSurname())
                .role(model.getRole())
                .rest_id(model.getRest_id())
                .id(model.getUser_id())
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(command);
        }
        catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }

    private String encrypt(String plainText, int shiftKey){
        String cipherText = "";
        for (char c : plainText.toCharArray()){
            int ascii =c;
            ascii += shiftKey;
            cipherText += ((char) ascii);
        }
        return cipherText;
    }

    private String decrypt(String cipherText, int shiftKey){
        String plainText = "";
        for (char c : cipherText.toCharArray()){
            int ascii = c;
            ascii -= shiftKey;
            plainText += ((char) ascii);
        }
        return plainText;
    }
}
