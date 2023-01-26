package com.example.reservservice.restaurant.data;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "restaurant")
public class Restaurant implements Serializable {
    @Id
    private String rest_id;
    private String address;
    private Double rating;
    private String branch;
    private String image;
}
