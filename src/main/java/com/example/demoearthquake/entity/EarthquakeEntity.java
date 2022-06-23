package com.example.demoearthquake.entity;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "EARTH")
@RequiredArgsConstructor
public class EarthquakeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "earthquake_id")
    private Integer id;

    private LocalDateTime occurred_on;
    private Double latitude;
    private Double longitude;
    private Float depth;
    private Float magnitude;
    private String calculation_method;
    private String network_id;
    private String place;
    private String cause;

}
