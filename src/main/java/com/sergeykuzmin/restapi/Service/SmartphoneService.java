package com.sergeykuzmin.restapi.Service;

import com.querydsl.core.types.Predicate;
import com.sergeykuzmin.restapi.dto.DeviceFilter;
import com.sergeykuzmin.restapi.dto.SmartphoneFilter;
import com.sergeykuzmin.restapi.model.Smartphone;
import com.sergeykuzmin.restapi.repository.SmartphoneRepository;
import com.sergeykuzmin.restapi.util.QPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import static com.sergeykuzmin.restapi.model.QSmartphone.smartphone;

@Service
public class SmartphoneService {

    @Autowired
    DeviceService deviceService;
    @Autowired
    SmartphoneRepository repository;


    private Predicate getSmartphonePredicate(DeviceFilter deviceFilter, SmartphoneFilter smartphoneFilter){

        return QPredicate.builder()
                .add(smartphoneFilter.getMemory(),smartphone.memory::eq)
                .add(smartphoneFilter.getCountOfCamera(),smartphone.countOfCamera::eq)
                .add(deviceService.getDevicePredicate(deviceFilter, smartphone._super))
                .buildAnd();
    }


    public Page<Smartphone> findByFilter(DeviceFilter deviceFilter, SmartphoneFilter smartphoneFilter){

        if(deviceService.needFilter(deviceFilter)|| smartphoneFilter.getMemory() != null || smartphoneFilter.getCountOfCamera() != null){

            return repository.findAll(getSmartphonePredicate(deviceFilter,smartphoneFilter),deviceService.getPagebale(deviceFilter));

        }else{

            return repository.findAll(deviceService.getPagebale(deviceFilter));
        }
    }



    public Smartphone addNewSmartphone(Smartphone smartphone){

        return repository.save(smartphone);
    }
}
