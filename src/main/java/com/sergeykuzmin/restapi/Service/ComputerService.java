package com.sergeykuzmin.restapi.Service;

import com.querydsl.core.types.Predicate;
import com.sergeykuzmin.restapi.dto.ComputerFilter;
import com.sergeykuzmin.restapi.dto.DeviceFilter;
import com.sergeykuzmin.restapi.model.Computer;
import com.sergeykuzmin.restapi.repository.ComputerRepository;
import com.sergeykuzmin.restapi.util.QPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import static com.sergeykuzmin.restapi.model.QComputer.computer;


@Service
public class ComputerService {
    @Autowired
    DeviceService deviceService;
    @Autowired
    ComputerRepository repository;


    private Predicate getComputerPredicate(DeviceFilter deviceFilter, ComputerFilter computerFilter){

        return QPredicate.builder()
                .add(computerFilter.getCategory(),computer.category::containsIgnoreCase)
                .add(computerFilter.getCpu(),computer.cpu::containsIgnoreCase)
                .add(deviceService.getDevicePredicate(deviceFilter, computer._super))
                .buildAnd();

    }


    public Page<Computer> findByFilter(DeviceFilter deviceFilter, ComputerFilter computerFilter){

        if(deviceService.needFilter(deviceFilter) || computerFilter.getCategory() != null || computerFilter.getCpu() != null){

            return repository.findAll(getComputerPredicate(deviceFilter,computerFilter), deviceService.getPagebale(deviceFilter));

        }else{
            return repository.findAll(deviceService.getPagebale(deviceFilter));

        }
    }


    public Computer addNewComputer(Computer computer){

        return repository.save(computer);
    }
}
