package com.example.userservice.query.projection;

import com.example.userservice.data.User;
import com.example.userservice.data.UserRepository;
import com.example.userservice.query.query.LogInQuery;
import com.example.userservice.query.query.ReadUserQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserProjection {
    @Autowired
    private UserRepository repository;

    @QueryHandler
    public User handler(LogInQuery query){
        User user = repository.LogIn(query.getEmail(), query.getPassword());
        return user;
    }

    @QueryHandler
    public List<User> handler(ReadUserQuery query){
        List<User>  users = repository.findAll();
        return users;
    }
}
