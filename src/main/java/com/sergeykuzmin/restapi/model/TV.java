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
@Table(name = "tv")
@Entity
public class TV extends Device {

    @Column(name = "category")
    private String category;
    @Column(name = "technology")
    private String technology;

    public TV() {
    }

    public TV(String name, String serialNumber, BigDecimal price, Company company, Country country, boolean availability, boolean orderOnline, boolean instalment, String category, String technology) {
        super(name, serialNumber, price, company, country, availability, orderOnline, instalment);
        this.category = category;
        this.technology = technology;
    }
}
