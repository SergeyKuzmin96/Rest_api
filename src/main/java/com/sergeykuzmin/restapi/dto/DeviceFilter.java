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

//    public DeviceFilter(String name, String serialNumber, BigDecimal priceFrom, BigDecimal priceTo, String color, Double length, Double height, Double width,
//                        String company, String country, Boolean availability, Boolean orderOnline, Boolean instalment, Integer pageNumber, Integer pageSize, String sortDirectional, String sortBy) {
//        this.name = name;
//        this.serialNumber = serialNumber;
//        this.priceFrom = priceFrom;
//        this.priceTo = priceTo;
//        this.color = color;
//        this.length = length;
//        this.height = height;
//        this.width = width;
//        this.company = company;
//        this.country = country;
//        this.availability = availability;
//        this.orderOnline = orderOnline;
//        this.instalment = instalment;
//        this.pageNumber = pageNumber;
//        this.pageSize = pageSize;
//        this.sortDirectional = sortDirectional;
//
//        if (sortBy.equalsIgnoreCase("price")) {
//
//            this.sortBy = sortBy;
//
//        } else {
//
//            this.sortBy = "name";
//        }
//
//    }

}