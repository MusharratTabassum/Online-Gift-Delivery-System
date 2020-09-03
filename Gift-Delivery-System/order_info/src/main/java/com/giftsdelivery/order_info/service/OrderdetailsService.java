package com.giftsdelivery.order_info.service;


import com.giftsdelivery.order_info.exception.ResourceAlreadyExistsException;
import com.giftsdelivery.order_info.exception.ResourceNotFoundException;
import com.giftsdelivery.order_info.model.OrderDetail;
import com.giftsdelivery.order_info.repository.OrderdetailsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderdetailsService {



    private OrderdetailsRepository orderdetailsRepository;

    public OrderdetailsService(OrderdetailsRepository orderdetailsRepository) {
        this.orderdetailsRepository = orderdetailsRepository;
    }

    public List<OrderDetail> findAll() {
        List<OrderDetail>orderDetailList = new ArrayList<>();
        orderdetailsRepository.findAll().forEach(orderDetailList::add);
        return orderDetailList;
    }
    public OrderDetail findById(int order_id) throws ResourceNotFoundException {
        OrderDetail orderDetail = orderdetailsRepository
                .findById(order_id)
                .orElseThrow(ResourceNotFoundException::new);
        return orderDetail;
    }
    public OrderDetail create(OrderDetail orderDetail) throws ResourceAlreadyExistsException {
        if (orderdetailsRepository.existsById(orderDetail.getOrder_id())) {
            throw new ResourceAlreadyExistsException();
        } else {
            OrderDetail savedOrder = orderdetailsRepository.save(orderDetail);
            return savedOrder;
        }
    }


}
