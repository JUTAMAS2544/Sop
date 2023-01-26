package com.example.userservice.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class UpdateUserCommand {
    @TargetAggregateIdentifier
    private String user_id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String role;
    private String rest_id;
    private String id;
}
