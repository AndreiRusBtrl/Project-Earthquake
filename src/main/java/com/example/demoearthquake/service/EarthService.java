package com.example.demoearthquake.service;


import com.example.demoearthquake.entity.EarthquakeEntity;
import com.example.demoearthquake.entity.EarthquakeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EarthService {


    private final EarthquakeRepo earthquakeRepo;

    public List<EarthquakeEntity> getAllEarthQuakeEntities() {
        return earthquakeRepo.findAll();
    }

    public List<EarthquakeEntity> earthQuakesForRestrictedAccess() {
        return earthquakeRepo.findByMagnitudeLessThan(8.1F);
    }

    public List<EarthquakeEntity> getAllEarthQuakeEntitiesByPlaceS(String place) {

        return earthquakeRepo.findByPlaceContaining(place);
    }

    public List<EarthquakeEntity> getRestrictedEarthQuakeEntitiesByPlace(String place) {

        return earthquakeRepo.findByPlaceContainingAndMagnitudeLessThan(place, 8.1F);
    }

    public void addEntity(EarthquakeEntity earthQuakeEntity) {
        earthquakeRepo.save(earthQuakeEntity);
    }

    public void updateEntity(EarthquakeEntity earthquakeEntityToUpdate, Integer id) {
        Optional<EarthquakeEntity> earthQuakeEntity = earthquakeRepo.findById(id);
        if (earthQuakeEntity.isPresent()) {
            if (earthquakeEntityToUpdate.getOccurred_on() != null) {
                earthQuakeEntity.get().setOccurred_on(earthquakeEntityToUpdate.getOccurred_on());
            }
            if (earthquakeEntityToUpdate.getLatitude() != null) {
                earthQuakeEntity.get().setLatitude(earthquakeEntityToUpdate.getLatitude());
            }
            if (earthquakeEntityToUpdate.getLongitude() != null) {
                earthQuakeEntity.get().setLongitude(earthquakeEntityToUpdate.getLongitude());
            }
            if (earthquakeEntityToUpdate.getDepth() != null) {
                earthQuakeEntity.get().setDepth(earthquakeEntityToUpdate.getDepth());
            }
            if (earthquakeEntityToUpdate.getMagnitude() != null) {
                earthQuakeEntity.get().setMagnitude(earthquakeEntityToUpdate.getMagnitude());
            }
            if (earthquakeEntityToUpdate.getCalculation_method() != null) {
                earthQuakeEntity.get().setCalculation_method(earthquakeEntityToUpdate.getCalculation_method());
            }
            if (earthquakeEntityToUpdate.getNetwork_id() != null) {
                earthQuakeEntity.get().setNetwork_id(earthquakeEntityToUpdate.getNetwork_id());
            }
            if (earthquakeEntityToUpdate.getPlace() != null) {
                earthQuakeEntity.get().setPlace(earthquakeEntityToUpdate.getPlace());
            }
            if (earthquakeEntityToUpdate.getCause() != null) {
                earthQuakeEntity.get().setCause(earthquakeEntityToUpdate.getCause());
            }
            earthquakeRepo.save(earthQuakeEntity.get());
        }
    }

    public void deleteEarthquakeById(Integer id) {
        Optional<EarthquakeEntity> person = earthquakeRepo.findById(id);
        person.ifPresent(earthquakeRepo::delete);
    }


}
