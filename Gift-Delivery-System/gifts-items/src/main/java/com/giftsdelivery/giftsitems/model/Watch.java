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
public class Watch {
    @Id
    private long id;
    private String name;
    private String brand_name;
    private double price;
    private String color;


}
