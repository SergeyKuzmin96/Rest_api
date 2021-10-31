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
@Table(name = "computers")
@Entity
public class Computer extends Device {
    @Column(name = "category")
    private String category;
    @Column(name = "cpu")
    private String cpu;

    public Computer() {
    }

    public Computer(String name, String serialNumber, BigDecimal price, Company company, Country country, boolean availability, boolean orderOnline, boolean instalment, String category, String cpu) {
        super(name, serialNumber, price, company, country, availability, orderOnline, instalment);
        this.category = category;
        this.cpu = cpu;
    }
}
