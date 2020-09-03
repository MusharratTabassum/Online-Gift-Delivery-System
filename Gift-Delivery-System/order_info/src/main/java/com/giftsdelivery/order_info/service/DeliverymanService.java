package com.giftsdelivery.order_info.service;

import com.giftsdelivery.order_info.exception.ResourceAlreadyExistsException;
import com.giftsdelivery.order_info.exception.ResourceNotFoundException;
import com.giftsdelivery.order_info.model.DeliveryMan;

import com.giftsdelivery.order_info.repository.DeliverymanRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliverymanService {

    private DeliverymanRepository deliverymanRepository;

    public DeliverymanService(DeliverymanRepository deliverymanRepository) {
        this.deliverymanRepository = deliverymanRepository;
    }

    public List<DeliveryMan> findAll() {
        List<DeliveryMan>deliveryManList = new ArrayList<>();
        deliverymanRepository.findAll().forEach(deliveryManList::add);
        return deliveryManList;
    }
    public DeliveryMan findById(int id) throws ResourceNotFoundException {
        DeliveryMan deliveryMan = deliverymanRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        return deliveryMan;
    }
    public DeliveryMan create(DeliveryMan deliveryMan) throws ResourceAlreadyExistsException {
        if (deliverymanRepository.existsById(deliveryMan.getId())) {
            throw new ResourceAlreadyExistsException();
        } else {
            DeliveryMan savedDeliveryman = deliverymanRepository.save(deliveryMan);
            return savedDeliveryman;
        }
    }
}
