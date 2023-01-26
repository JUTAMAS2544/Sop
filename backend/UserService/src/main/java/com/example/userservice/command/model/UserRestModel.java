package com.example.userservice.command.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserRestModel implements Serializable {
    private String email;
    private String password;
    private String name;
    private String surname;
}
