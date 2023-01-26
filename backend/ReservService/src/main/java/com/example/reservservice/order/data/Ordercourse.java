package com.example.reservservice.order.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ordercourse")
public class Ordercourse implements Serializable {
    @Id
    private String order_id;
    private Double price;
    private Double discount;
    private Double total_price;
    private String reserv_id;
}
