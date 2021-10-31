package com.sergeykuzmin.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CleanerFilter {

    private Double collectorVolume;

    private Integer countOfMode;
}
