package com.sergeykuzmin.restapi.Service;

import com.querydsl.core.types.Predicate;
import com.sergeykuzmin.restapi.dto.DeviceFilter;
import com.sergeykuzmin.restapi.model.QDevice;
import com.sergeykuzmin.restapi.util.QPredicate;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {


    Boolean needFilter(DeviceFilter deviceFilter) {

        return deviceFilter.getName() != null || deviceFilter.getSerialNumber() != null || deviceFilter.getPriceFrom() != null || deviceFilter.getPriceTo() != null || deviceFilter.getColor() != null
                || deviceFilter.getHeight() != null || deviceFilter.getLength() != null || deviceFilter.getWidth() != null || deviceFilter.getCompany() != null || deviceFilter.getCountry() != null
                || deviceFilter.getAvailability() != null || deviceFilter.getOrderOnline() != null || deviceFilter.getInstalment() != null;

    }


    Pageable getPagebale(DeviceFilter deviceFilter) {

        String sortBy;

        if(deviceFilter.getSortBy() != null && deviceFilter.getSortBy().equalsIgnoreCase("price")){
            sortBy = "price";
        }else{
            sortBy = "name";
        }

        Sort.Direction direction;

        if (deviceFilter.getSortDirectional() != null && deviceFilter.getSortDirectional().equalsIgnoreCase("DESC")) {
            direction = Sort.Direction.DESC;
        } else {
            direction = Sort.Direction.ASC;
        }

        Integer pageN = 0;
        Integer pageS = 10;

        if (deviceFilter.getPageNumber() != null) {
            pageN = deviceFilter.getPageNumber();
        }
        if (deviceFilter.getPageSize() != null) {
            pageS = deviceFilter.getPageSize();
        }

        Sort sort = Sort.by(direction, sortBy);

        return PageRequest.of(pageN, pageS, sort);

    }


    Predicate getDevicePredicate(DeviceFilter filter, QDevice device) {

        return QPredicate.builder()
                .add(filter.getName(), device.name::containsIgnoreCase)
                .add(filter.getSerialNumber(), device.serialNumber::containsIgnoreCase)
                .add(filter.getPriceFrom(), device.price::loe)
                .add(filter.getPriceTo(), device.price::goe)
                .add(filter.getColor(), device.color::containsIgnoreCase)
                .add(filter.getLength(), device.length::eq)
                .add(filter.getHeight(), device.height::eq)
                .add(filter.getWidth(), device.width::eq)
                .add(filter.getCompany(), device.company.name::containsIgnoreCase)
                .add(filter.getCountry(), device.country.name::containsIgnoreCase)
                .add(filter.getAvailability(), device.availability::eq)
                .add(filter.getOrderOnline(), device.orderOnline::eq)
                .add(filter.getInstalment(), device.instalment::eq)
                .buildAnd();

    }
}
