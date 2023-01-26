package com.example.reviewservice.query.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReadReviewQuery implements Serializable {
    private String rest_id;
}
