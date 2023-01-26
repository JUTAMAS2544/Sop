package com.example.menuservice.food.data;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Food implements Serializable {
    @Id
    private String food_id;
    private String name;
    private String image;
}
