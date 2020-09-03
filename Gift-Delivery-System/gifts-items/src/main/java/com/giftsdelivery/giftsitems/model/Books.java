package com.giftsdelivery.giftsitems.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Books {

    @Id
    private int serial_no;
    private String book_name;
    private String writter_name;
    private String publisher_name;
    private String type;
    private double price;

}
