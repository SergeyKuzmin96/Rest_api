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
@Table(name = "cleaners")
@Entity
public class Cleaner extends Device {
    @Column(name = "collector_volume")
    private Double collectorVolume;
    @Column(name = "count_of_mode")
    private Integer countOfMode;

    public Cleaner() {
    }

    public Cleaner(String name, String serialNumber, BigDecimal price, Company company, Country country, boolean availability, boolean orderOnline, boolean instalment, Double collectorVolume, Integer countOfMode) {
        super(name, serialNumber, price, company, country, availability, orderOnline, instalment);
        this.collectorVolume = collectorVolume;
        this.countOfMode = countOfMode;
    }
}
