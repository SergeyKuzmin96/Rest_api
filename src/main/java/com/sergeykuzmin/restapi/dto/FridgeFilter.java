package com.sergeykuzmin.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FridgeFilter {

    private Integer countOfDoor;


    private String compressor;
}
