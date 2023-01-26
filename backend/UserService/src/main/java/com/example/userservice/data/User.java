package com.example.userservice.data;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "User")
public class User implements Serializable {
    @Id
    private String user_id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String role;
    private String rest_id;
}
