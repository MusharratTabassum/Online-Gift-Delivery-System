package com.giftsdelivery.giftsitems.repository;

import com.giftsdelivery.giftsitems.model.Shops_Details;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shops_Details,Integer> {
}
