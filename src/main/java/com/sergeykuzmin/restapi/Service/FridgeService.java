package com.sergeykuzmin.restapi.Service;

import com.querydsl.core.types.Predicate;
import com.sergeykuzmin.restapi.dto.DeviceFilter;
import com.sergeykuzmin.restapi.dto.FridgeFilter;
import com.sergeykuzmin.restapi.model.Fridge;
import com.sergeykuzmin.restapi.repository.FridgeRepository;
import com.sergeykuzmin.restapi.util.QPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import static com.sergeykuzmin.restapi.model.QFridge.fridge;

@Service
public class FridgeService {

    @Autowired
    DeviceService deviceService;
    @Autowired
    FridgeRepository repository;


    private Predicate getFridgePredicate(DeviceFilter deviceFilter, FridgeFilter fridgeFilter){

        return QPredicate.builder()
                .add(fridgeFilter.getCountOfDoor(),fridge.countOfDoor::eq)
                .add(fridgeFilter.getCompressor(),fridge.compressor::containsIgnoreCase)
                .add(deviceService.getDevicePredicate(deviceFilter, fridge._super))
                .buildAnd();
    }


    public Page<Fridge> findByFilter(DeviceFilter deviceFilter, FridgeFilter fridgeFilter){

        if(deviceService.needFilter(deviceFilter)|| fridgeFilter.getCountOfDoor() != null || fridgeFilter.getCompressor() != null){

            return repository.findAll(getFridgePredicate(deviceFilter,fridgeFilter), deviceService.getPagebale(deviceFilter));

        } else {
            return repository.findAll(deviceService.getPagebale(deviceFilter));
        }
    }


    public Fridge addNewFridge(Fridge fridge){

        return repository.save(fridge);
    }
}
