package com.giftsdelivery.order_info.repository;

import com.giftsdelivery.order_info.model.DeliveryMan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverymanRepository extends CrudRepository<DeliveryMan,Integer> {
}
