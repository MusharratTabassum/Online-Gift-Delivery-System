package com.giftsdelivery.giftsitems.repository;

import com.giftsdelivery.giftsitems.model.Saree;
import com.giftsdelivery.giftsitems.model.Watch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SareeRepository  extends CrudRepository<Saree, Integer> {

}