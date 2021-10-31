package com.sergeykuzmin.restapi.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@Table(name = "fridges")
@Entity
public class Fridge extends Device {
    @Column(name = "count_of_door")
    private Integer countOfDoor;

    @Column(name = "compressor")
    private String compressor;

    public Fridge() {
    }

    public Fridge(String name, String serialNumber, BigDecimal price, Company company, Country country, boolean availability, boolean orderOnline, boolean instalment, Integer countOfDoor, String compressor) {
        super(name, serialNumber, price, company, country, availability, orderOnline, instalment);
        this.countOfDoor = countOfDoor;
        this.compressor = compressor;
    }
}