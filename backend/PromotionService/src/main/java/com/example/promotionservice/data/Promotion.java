package com.example.promotionservice.data;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "Promotion")
public class Promotion implements Serializable {
    @Id
    private String promotion_id;
    private String code;
    private Integer quantity;
    private Double discount;
}
