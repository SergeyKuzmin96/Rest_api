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
@Entity
@Table(name = "smartphones")
public class Smartphone  extends Device {

    @Column(name = "memory")
    private Integer memory;
    @Column(name = "count_of_camera")
    private Integer countOfCamera;

    public Smartphone() {
    }

    public Smartphone(String name, String serialNumber, BigDecimal price, Company company, Country country, boolean availability, boolean orderOnline, boolean instalment, Integer memory, Integer countOfCamera) {
        super(name, serialNumber, price, company, country, availability, orderOnline, instalment);
        this.memory = memory;
        this.countOfCamera = countOfCamera;
    }
}
