package com.example.userservice.command.aggregate;

import com.example.userservice.command.commands.CreateUserCommand;
import com.example.userservice.command.commands.UpdateUserCommand;
import com.example.userservice.command.event.UserCreateEvent;
import com.example.userservice.command.event.UserUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class UserAggregate {
    @AggregateIdentifier
    private String user_id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String role;
    private String rest_id;
    private String id;

    public UserAggregate() {
    }

    @CommandHandler
    public UserAggregate(CreateUserCommand command) {
        if(command.getEmail() == null || command.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email can't be empty");
        }

        if(command.getPassword() == null || command.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password can't be empty");
        }

        if(command.getName() == null || command.getName().isBlank()) {
            throw new IllegalArgumentException("Name can't be empty");
        }

        if(command.getSurname() == null || command.getSurname().isBlank()) {
            throw new IllegalArgumentException("Surname can't be empty");
        }

        UserCreateEvent event = new UserCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UserCreateEvent event){
        this.user_id = event.getUser_id();
        this.email = event.getEmail();
        this.password = event.getPassword();
        this.name = event.getName();
        this.surname = event.getSurname();
        this.role = event.getRole();
    }

    @CommandHandler
    public UserAggregate(UpdateUserCommand command) {
        if(command.getEmail() == null || command.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email can't be empty");
        }

        if(command.getPassword() == null || command.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password can't be empty");
        }

        if(command.getName() == null || command.getName().isBlank()) {
            throw new IllegalArgumentException("Name can't be empty");
        }

        if(command.getSurname() == null || command.getSurname().isBlank()) {
            throw new IllegalArgumentException("Surname can't be empty");
        }

        UserUpdateEvent event = new UserUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UserUpdateEvent event){
        this.user_id = event.getUser_id();
        this.email = event.getEmail();
        this.password = event.getPassword();
        this.name = event.getName();
        this.surname = event.getSurname();
        this.role = event.getRole();
        this.rest_id = event.getRest_id();
        this.id = event.getId();
    }
}
