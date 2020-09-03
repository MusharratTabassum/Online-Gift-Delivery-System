package com.giftsdelivery.order_info.controller;


import com.giftsdelivery.order_info.exception.ResourceAlreadyExistsException;
import com.giftsdelivery.order_info.exception.ResourceNotFoundException;
import com.giftsdelivery.order_info.model.DeliveryMan;

import com.giftsdelivery.order_info.service.DeliverymanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("deliveryman")
public class DeliverymanController {

    private DeliverymanService deliverymanService ;

    public DeliverymanController(DeliverymanService deliverymanService) {
        this.deliverymanService = deliverymanService;
    }

    @GetMapping("")
    public ResponseEntity<List<DeliveryMan>> getDeliverymans() {
        List<DeliveryMan> deliveryManList = deliverymanService.findAll();
        return ResponseEntity.ok(deliveryManList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryMan> getDeliveryman(@PathVariable int id) {
        try {
            DeliveryMan deliveryMan = deliverymanService.findById(id);
            return ResponseEntity.ok(deliveryMan);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("")
    public ResponseEntity<DeliveryMan> createDeliveryman(@RequestBody DeliveryMan deliveryMan) {
        try {
            DeliveryMan createdDeliveryman = deliverymanService.create(deliveryMan);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdDeliveryman);
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
