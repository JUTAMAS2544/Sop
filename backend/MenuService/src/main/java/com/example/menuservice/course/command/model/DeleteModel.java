package com.example.menuservice.course.command.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeleteModel implements Serializable {
    private String id;
}
