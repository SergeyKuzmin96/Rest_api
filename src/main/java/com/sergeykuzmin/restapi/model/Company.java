package com.sergeykuzmin.restapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table(name = "company")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
//    List<? extends Device>devices;
//
////    public <T extends Device>void addDeviceToCountry(T device){
////        if(devices == null){
////            devices = new ArrayList<>();
////        }
////        if(device instanceof TV){
////
////
////        }
////        devices.add((TV)device);
////        device.setCompany(this);
////    }

}
