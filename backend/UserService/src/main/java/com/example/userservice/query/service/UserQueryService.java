package com.example.userservice.query.service;

import com.example.userservice.data.User;
import com.example.userservice.query.query.LogInQuery;
import com.example.userservice.query.query.ReadUserQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserQueryService {
    @Autowired
    private QueryGateway queryGateway;

    @RabbitListener(queues = "ReadUser")
    public User getProfile(LogInQuery query){
        query.setPassword(encrypt(query.getPassword(), 10));
        User model = queryGateway.query(query, ResponseTypes.instanceOf(User.class)).join();
        model.setPassword(decrypt(model.getPassword(), 10));
        return model;
    }
    @RabbitListener(queues = "ReadAllUser")
    public List<User> getAllProfile(String s){
        ReadUserQuery query = new ReadUserQuery();
        List<User> users = queryGateway.query(query, ResponseTypes.multipleInstancesOf(User.class)).join();
        return users;
    }

    private String encrypt(String plainText, int shiftKey){
        String cipherText = "";
        for (char c : plainText.toCharArray()){
            int ascii = c;
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
