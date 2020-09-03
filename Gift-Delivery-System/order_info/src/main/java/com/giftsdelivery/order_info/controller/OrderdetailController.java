package com.giftsdelivery.order_info.controller;


import com.giftsdelivery.order_info.exception.ResourceAlreadyExistsException;
import com.giftsdelivery.order_info.exception.ResourceNotFoundException;
import com.giftsdelivery.order_info.model.OrderDetail;
import com.giftsdelivery.order_info.service.OrderdetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orderdetail")
public class OrderdetailController {

    private OrderdetailsService orderdetailsService ;

    public OrderdetailController(OrderdetailsService orderdetailsService) {
        this.orderdetailsService = orderdetailsService;
    }

    @GetMapping("")
    public ResponseEntity<List<OrderDetail>> getOrders() {
        List<OrderDetail> orderDetailList = orderdetailsService.findAll();
        return ResponseEntity.ok(orderDetailList);
    }

    @GetMapping("/{order_id}")
    public ResponseEntity<OrderDetail> getBook(@PathVariable int order_id) {
        try {
            OrderDetail orderDetail = orderdetailsService.findById(order_id);
            return ResponseEntity.ok(orderDetail);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("")
    public ResponseEntity<OrderDetail> createBook(@RequestBody OrderDetail orderDetail) {
        try {
            OrderDetail createdOrder = orderdetailsService.create(orderDetail);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
