package com.example.demoearthquake.controller;


import com.example.demoearthquake.entity.EarthQuakeEntity;
import com.example.demoearthquake.entity.EarthquakeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/normal_people/")
public class EarthController {

    private final EarthquakeRepo earthquakeRepo;



    @GetMapping("/get_all_earthquakes")
    public List<EarthQuakeEntity> earthQuakeEntities(){
        return  earthquakeRepo.findAll();
    }

}
