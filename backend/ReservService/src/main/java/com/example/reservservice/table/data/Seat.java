package com.example.reservservice.table.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "seat")
public class Seat implements Serializable {
    @Id
    private String table_id;
    private String status;
    private String rest_id;
    private Integer table_no;
}
