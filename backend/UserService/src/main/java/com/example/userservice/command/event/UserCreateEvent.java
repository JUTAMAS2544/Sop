package com.example.userservice.command.event;

import lombok.Data;

@Data
public class UserCreateEvent {
    private String user_id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String role;

}
