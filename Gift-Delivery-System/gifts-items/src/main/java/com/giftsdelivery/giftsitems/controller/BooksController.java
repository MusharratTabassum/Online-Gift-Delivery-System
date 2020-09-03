package com.giftsdelivery.giftsitems.controller;

import com.giftsdelivery.giftsitems.exeption.ResourceAlreadyExistsException;
import com.giftsdelivery.giftsitems.exeption.ResourceNotFoundException;
import com.giftsdelivery.giftsitems.model.Books;
import com.giftsdelivery.giftsitems.model.Watch;
import com.giftsdelivery.giftsitems.service.BooksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("books")
public class BooksController {

    private BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("")
    public ResponseEntity<List<Books>> getBooks() {
        List<Books> booksList = booksService.findAll();
        return ResponseEntity.ok(booksList);
    }

    @GetMapping("/{serial_no}")
    public ResponseEntity<Books> getBook(@PathVariable int serial_no) {
        try {
            Books books = booksService.findById(serial_no);
            return ResponseEntity.ok(books);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Books> createBook(@RequestBody Books books) {
        try {
            Books createdBook = booksService.create(books);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
