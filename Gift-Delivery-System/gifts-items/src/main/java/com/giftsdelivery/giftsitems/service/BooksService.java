package com.giftsdelivery.giftsitems.service;


import com.giftsdelivery.giftsitems.exeption.ResourceAlreadyExistsException;
import com.giftsdelivery.giftsitems.exeption.ResourceNotFoundException;
import com.giftsdelivery.giftsitems.model.Books;
import com.giftsdelivery.giftsitems.model.Saree;
import com.giftsdelivery.giftsitems.model.Watch;
import com.giftsdelivery.giftsitems.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {

    private BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


    public List<Books> findAll() {
        List<Books>booksList = new ArrayList<>();
        booksRepository.findAll().forEach(booksList::add);
        return booksList;
    }
    public Books findById(int serial_no) throws ResourceNotFoundException {
        Books books = booksRepository
                .findById(serial_no)
                .orElseThrow(ResourceNotFoundException::new);
        return books;
    }
    public Books create(Books books) throws ResourceAlreadyExistsException {
        if (booksRepository.existsById(books.getSerial_no())) {
            throw new ResourceAlreadyExistsException();
        } else {
            Books savedBook = booksRepository.save(books);
            return savedBook;
        }
    }

    // findByName === how it works====
//    public Books findByName(String bookName) throws ResourceNotFoundException {
//        List<Books> booksList = findAll();
//        Books foundBook = null;
//        for(Books book : booksList){
//            if(book.getType() == bookName){
//                foundBook =  book;
//            }
//        }
//        if(foundBook == null){
//            throw new ResourceNotFoundException();
//        }
//        else{
//            return foundBook;
//        }
//    }


}
