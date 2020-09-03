package com.giftsdelivery.giftsitems.service;


import com.giftsdelivery.giftsitems.exeption.ResourceAlreadyExistsException;
import com.giftsdelivery.giftsitems.exeption.ResourceNotFoundException;
import com.giftsdelivery.giftsitems.model.Saree;
import com.giftsdelivery.giftsitems.repository.SareeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SareeService {

    private SareeRepository sareeRepository;

    public SareeService(SareeRepository sareeRepository) {
        this.sareeRepository = sareeRepository;
    }

    public List<Saree> findAll() {
        List<Saree>sareeList = new ArrayList<>();
        sareeRepository.findAll().forEach(sareeList::add);
        return sareeList;
    }
    public Saree findById(int code_no) throws ResourceNotFoundException {
       Saree saree = sareeRepository
                .findById(code_no)
                .orElseThrow(ResourceNotFoundException::new);
        return saree;
    }
    public Saree create(Saree saree) throws ResourceAlreadyExistsException {
        if (sareeRepository.existsById(saree.getCode_no())) {
            throw new ResourceAlreadyExistsException();
        } else {
            Saree savedSaree = sareeRepository.save(saree);
            return savedSaree;
        }
    }


}
