package com.example.userservice.query.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class LogInQuery implements Serializable {
    private String email;
    private String password;
}
