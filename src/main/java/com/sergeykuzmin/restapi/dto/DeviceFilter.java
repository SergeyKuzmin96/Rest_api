package com.sergeykuzmin.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeviceFilter {


    private String name;

    private String serialNumber;

    private BigDecimal priceFrom;

    private BigDecimal priceTo;

    private String color;

    private Double length;

    private Double height;

    private Double width;

    private String company;

    private String country;

    private Boolean availability;

    private Boolean orderOnline;

    private Boolean instalment;

    private Integer pageNumber;

    private Integer pageSize;

    private String sortDirectional;

    private String sortBy ;


}