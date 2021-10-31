package com.sergeykuzmin.restapi.Service;

import com.querydsl.core.types.Predicate;
import com.sergeykuzmin.restapi.dto.CleanerFilter;
import com.sergeykuzmin.restapi.dto.DeviceFilter;
import com.sergeykuzmin.restapi.model.Cleaner;
import com.sergeykuzmin.restapi.repository.CleanerRepository;
import com.sergeykuzmin.restapi.util.QPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import static com.sergeykuzmin.restapi.model.QCleaner.cleaner;

@Service
public class CleanerService {
    @Autowired
    DeviceService deviceService;
    @Autowired
    CleanerRepository repository;


    private Predicate getCleanerPredicate(DeviceFilter deviceFilter, CleanerFilter cleanerFilter) {

        return QPredicate.builder()
                .add(cleanerFilter.getCollectorVolume(), cleaner.collectorVolume::eq)
                .add(cleanerFilter.getCountOfMode(), cleaner.countOfMode::eq)
                .add(deviceService.getDevicePredicate(deviceFilter, cleaner._super))
                .buildAnd();

    }


    public Page<Cleaner> findByFilter(DeviceFilter deviceFilter, CleanerFilter cleanerFilter) {

        if (deviceService.needFilter(deviceFilter) || cleanerFilter.getCountOfMode() != null || cleanerFilter.getCollectorVolume() != null) {

            return repository.findAll(getCleanerPredicate(deviceFilter, cleanerFilter), deviceService.getPagebale(deviceFilter));

        } else {
            return repository.findAll(deviceService.getPagebale(deviceFilter));

        }
    }


    public Cleaner addNewCleaner(Cleaner cleaner) {

        return repository.save(cleaner);
    }
}
