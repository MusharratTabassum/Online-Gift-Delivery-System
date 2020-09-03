package com.giftsdelivery.order_info.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class DeliveryMan {

    @Id
    private int id;
    private String name;
    private Long phoneNumber;
    @ManyToMany
    private List<OrderDetail> orderDetailList;

    public DeliveryMan(int id, String name, Long phoneNumber) {
        this.id = id;
        this.name = name;
        phoneNumber = phoneNumber;
    }
    public void addOrderDeliveryInfo(OrderDetail orderDetail)
    {
        if(orderDetailList==null)
            orderDetailList=new ArrayList<>();

        orderDetailList.add(orderDetail);
    }

}
