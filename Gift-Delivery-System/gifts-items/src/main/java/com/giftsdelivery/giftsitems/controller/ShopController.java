package com.giftsdelivery.giftsitems.controller;

import com.giftsdelivery.giftsitems.exeption.ResourceAlreadyExistsException;
import com.giftsdelivery.giftsitems.exeption.ResourceNotFoundException;
import com.giftsdelivery.giftsitems.model.Shops_Details;
import com.giftsdelivery.giftsitems.service.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("shops_details")
public class ShopController {
    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("")
    public ResponseEntity<List<Shops_Details>> getShops() {
        List<Shops_Details> shops_detailsList = shopService.findAll();
        return ResponseEntity.ok(shops_detailsList);
    }

    @GetMapping("/{shop_no}")
    public ResponseEntity<Shops_Details> getShop(@PathVariable int shop_no) {
        try {
            Shops_Details shops_details = shopService.findById(shop_no);
            return ResponseEntity.ok(shops_details);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("")
    public ResponseEntity<Shops_Details> createWatch(@RequestBody Shops_Details shops_details) {
        try {
            Shops_Details createdShop = shopService.create(shops_details);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdShop);
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/{shop_no}")
    public ResponseEntity<Shops_Details> updateShop(@PathVariable int shop_no, @RequestBody Shops_Details shops_details) {
        try {
            Shops_Details updatedshop = shopService.updateShop(shop_no, shops_details);
            return ResponseEntity.ok(updatedshop);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
