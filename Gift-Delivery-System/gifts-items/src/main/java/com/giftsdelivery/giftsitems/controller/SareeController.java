package com.giftsdelivery.giftsitems.controller;


import com.giftsdelivery.giftsitems.exeption.ResourceAlreadyExistsException;
import com.giftsdelivery.giftsitems.exeption.ResourceNotFoundException;
import com.giftsdelivery.giftsitems.model.Saree;
import com.giftsdelivery.giftsitems.service.SareeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("saree")
public class SareeController {

    private SareeService sareeService;

    public SareeController(SareeService sareeService) {
        this.sareeService = sareeService;
    }

    @GetMapping("")
    public ResponseEntity<List<Saree>> getSarees() {
        List<Saree> sareeList = sareeService.findAll();
        return ResponseEntity.ok(sareeList);
    }

    @GetMapping("/{code_no}")
    public ResponseEntity<Saree> getSaree(@PathVariable int code_no) {
        try {
            Saree saree = sareeService.findById(code_no);
            return ResponseEntity.ok(saree);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("")
    public ResponseEntity<Saree> createSaree(@RequestBody Saree Saree) {
        try {
            Saree createdSaree = sareeService.create(Saree);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdSaree);
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }




}
