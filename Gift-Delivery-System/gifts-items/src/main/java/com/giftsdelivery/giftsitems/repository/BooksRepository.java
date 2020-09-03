package com.giftsdelivery.giftsitems.repository;


import com.giftsdelivery.giftsitems.model.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends CrudRepository<Books, Integer> {


}