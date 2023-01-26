package com.example.reviewservice.query.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReadRatingQuery implements Serializable {
    private String rest_id;
}
