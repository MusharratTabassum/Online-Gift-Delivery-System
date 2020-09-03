package com.giftsdelivery.giftsitems.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Saree {
    @Id
    private int code_no;
    private String name;
    private double price;
    private String type;
    private String color;

}
