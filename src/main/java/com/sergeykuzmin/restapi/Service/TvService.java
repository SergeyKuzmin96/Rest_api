package com.sergeykuzmin.restapi.Service;


import com.querydsl.core.types.Predicate;
import com.sergeykuzmin.restapi.dto.DeviceFilter;
import com.sergeykuzmin.restapi.dto.TvFilter;
import com.sergeykuzmin.restapi.model.TV;
import com.sergeykuzmin.restapi.repository.CompanyRepository;
import com.sergeykuzmin.restapi.repository.CountryRepository;
import com.sergeykuzmin.restapi.repository.TvRepository;
import com.sergeykuzmin.restapi.util.QPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import static com.sergeykuzmin.restapi.model.QTV.tV;

@Service
public class TvService {

    @Autowired
    DeviceService deviceService;
    @Autowired
    TvRepository repository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CountryRepository countryRepository;


    private Predicate getTvPredicate(DeviceFilter  deviceFilter, TvFilter tvFilter){
        return QPredicate.builder()
                .add(tvFilter.getCategory(),tV.category::containsIgnoreCase)
                .add(tvFilter.getTechnology(),tV.technology::containsIgnoreCase)
                .add(deviceService.getDevicePredicate(deviceFilter, tV._super))
                .buildAnd();

    }


    public Page<TV> findByFilter(DeviceFilter deviceFilter, TvFilter tvFilter){
        if(deviceService.needFilter(deviceFilter)|| tvFilter.getCategory() != null || tvFilter.getTechnology() != null){

            return repository.findAll(getTvPredicate(deviceFilter,tvFilter), deviceService.getPagebale(deviceFilter));
        }else {
            return repository.findAll(deviceService.getPagebale(deviceFilter));
        }
    }


    public TV addNewTv(TV tv){

        return repository.save(tv);
    }
}
