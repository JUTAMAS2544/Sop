package com.example.reviewservice.command.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ReviewRestModel implements Serializable {
    private String comment;
    private String  rest_id;
    private String user_id;
    private Integer rating;
}
