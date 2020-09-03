package com.giftsdelivery.giftsitems.service;


import com.giftsdelivery.giftsitems.exeption.ResourceAlreadyExistsException;
import com.giftsdelivery.giftsitems.exeption.ResourceNotFoundException;
import com.giftsdelivery.giftsitems.model.Watch;
import com.giftsdelivery.giftsitems.repository.WatchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WatchService {

    private WatchRepository watchRepository;

    public WatchService(WatchRepository watchRepository) {
        this.watchRepository = watchRepository;
    }

    public List<Watch> findAll() {
        List<Watch>watchList = new ArrayList<>();
        watchRepository.findAll().forEach(watchList::add);
        return watchList;
    }
    public Watch findById(long id) throws ResourceNotFoundException {
       Watch watch = watchRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        return watch;
    }


    public Watch create(Watch watch) throws ResourceAlreadyExistsException {
        if (watchRepository.existsById(watch.getId())) {
            throw new ResourceAlreadyExistsException();
        } else {
            Watch savedWatch = watchRepository.save(watch);
            return savedWatch;
        }
    }


}
