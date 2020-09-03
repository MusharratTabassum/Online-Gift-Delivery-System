package com.giftsdelivery.order_info.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDetail {
    @Id
    private int order_id;
    private double orderPrice;
    private long cardNumber;
    private String cardHolderName;
    private String deliveryLocation;
    private LocalDate deliveryTime;
    private long custPhonenumber;
}
