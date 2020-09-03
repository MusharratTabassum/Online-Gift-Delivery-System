package com.giftsdelivery.giftsitems.controller;


import com.giftsdelivery.giftsitems.exeption.ResourceAlreadyExistsException;
import com.giftsdelivery.giftsitems.exeption.ResourceNotFoundException;
import com.giftsdelivery.giftsitems.model.Watch;
import com.giftsdelivery.giftsitems.service.WatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("watch")
public class WatchController {

    private WatchService watchService;

    public WatchController(WatchService watchService) {
        this.watchService = watchService;
    }

    @GetMapping("")
    public ResponseEntity<List<Watch>> getWatchs() {
        List<Watch> watchList = watchService.findAll();
        return ResponseEntity.ok(watchList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Watch> getWatch(@PathVariable long id) {
        try {
            Watch watch = watchService.findById(id);
            return ResponseEntity.ok(watch);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("")
    public ResponseEntity<Watch> createWatch(@RequestBody Watch watch) {
        try {
            Watch createdWatch = watchService.create(watch);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdWatch);
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
