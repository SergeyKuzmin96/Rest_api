package com.sergeykuzmin.restapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Getter
@Setter
@MappedSuperclass
public abstract class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name ="name")
    private String name;
    @Column(name = "serial_number")
    private String serialNumber;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "color")
    private String color;
    @Column(name = "length")
    private Double length;
    @Column(name = "height")
    private Double height;
    @Column(name= "width")
    private Double width;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(cascade = { CascadeType.MERGE})
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "availability")
    private boolean availability;
    @Column(name = "order_online")
    private boolean orderOnline;
    @Column(name = "instalment")
    private boolean instalment;

    public Device() {
    }

    public Device(String name, String serialNumber, BigDecimal price, Company company, Country country, boolean availability, boolean orderOnline, boolean instalment) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.price = price;
        this.company = company;
        this.country = country;
        this.availability = availability;
        this.orderOnline = orderOnline;
        this.instalment = instalment;
    }
}
