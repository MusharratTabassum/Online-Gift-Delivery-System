package com.giftsdelivery.giftsitems.service;


import com.giftsdelivery.giftsitems.exeption.ResourceAlreadyExistsException;
import com.giftsdelivery.giftsitems.exeption.ResourceNotFoundException;
import com.giftsdelivery.giftsitems.model.Books;
import com.giftsdelivery.giftsitems.model.Shops_Details;
import com.giftsdelivery.giftsitems.repository.BooksRepository;
import com.giftsdelivery.giftsitems.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
    private ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }


    public List<Shops_Details> findAll() {
        List<Shops_Details>shops_detailsList = new ArrayList<>();
        shopRepository.findAll().forEach(shops_detailsList::add);
        return shops_detailsList;
    }
    public Shops_Details findById(int shop_no) throws ResourceNotFoundException {
        Shops_Details shops_details = shopRepository
                .findById(shop_no)
                .orElseThrow(ResourceNotFoundException::new);
        return shops_details;
    }
    public Shops_Details create(Shops_Details shops_details) throws ResourceAlreadyExistsException {
        if (shopRepository.existsById(shops_details.getShop_no())) {
            throw new ResourceAlreadyExistsException();
        } else {
            Shops_Details savedShop = shopRepository.save(shops_details);
            return savedShop;
        }
    }
    public Shops_Details updateShop(int shop_no, Shops_Details shops_details) throws ResourceNotFoundException{
        Optional<Shops_Details> optionalShops_details= shopRepository.findById(shop_no);
        if (optionalShops_details.isPresent()) {
            shops_details.setShop_no(shop_no);
            Shops_Details savedShops_Details = shopRepository.save(shops_details);

             return savedShops_Details;
        } else {
            throw new ResourceNotFoundException();
        }
    }

}
