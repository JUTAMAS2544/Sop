package com.example.reviewservice.data;


import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "review")
public class Review implements Serializable {
    @Id
    private String rv_id;
    private String comment;
    private String rest_id;
    private String user_id;
    private Integer rating;
}
