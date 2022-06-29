package com.example.demoearthquake.controller;


import com.example.demoearthquake.entity.EarthquakeEntity;
import com.example.demoearthquake.service.EarthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/db/api/v1")
public class EarthController {

    private final EarthService earthService;

    @GetMapping("/get_all_earthquakes")
    public List<EarthquakeEntity> getAllEarthQuakeEntities(){
        return  earthService.getAllEarthQuakeEntities();
    }

    @GetMapping("/get_restricted_earthquakes")
    public List<EarthquakeEntity> getRestrictedEarthQuakeEntities() {
        return earthService.earthQuakesForRestrictedAccess();
    }

    @GetMapping("/get/{place}")
    public List<EarthquakeEntity> getAllByPlace(@PathVariable String place){
        return  earthService.getAllEarthQuakeEntitiesByPlaceS(place);
    }

    @GetMapping("/get_restricted/{place}")
    public List<EarthquakeEntity> getRestrictedByPlace(@PathVariable String place){
        return  earthService.getRestrictedEarthQuakeEntitiesByPlace(place);
    }

    @PostMapping("/add")
    public void addEarthquake(@RequestBody EarthquakeEntity earthQuake){
        earthService.addEntity(earthQuake);
    }

    @PutMapping("/update/{id}")
    public void updateEarthquake(@RequestBody EarthquakeEntity earthQuake, @PathVariable BigInteger id){
        earthService.updateEntity(earthQuake, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable BigInteger id){
        earthService.deleteEarthquakeById(id);
    }

}
