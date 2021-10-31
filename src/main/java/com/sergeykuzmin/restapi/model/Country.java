package com.sergeykuzmin.restapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table(name = "country")
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "country")
//    List<Device> devices;
//
//    public void addDeviceToCountry(Device device){
//        if(devices == null){
//            devices = new ArrayList<>();
//        }
//        devices.add(device);
//        device.setCountry(this);
//    }


}
