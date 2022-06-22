package com.example.demoearthquake.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EarthquakeRepo extends JpaRepository<EarthquakeEntity, Integer> {

    List<EarthquakeEntity> findByPlaceContaining(String place);
//    @Query(value = "select * from earth e where e.PLACE like %:place%", nativeQuery = true)
//    public List<EarthquakeEntity> getAllEarthQuakeEntitiesByPlace(@Param("place") String place);
    List<EarthquakeEntity> findByPlaceContainingAndMagnitudeLessThan(String infix, Float aFloat);
    List<EarthquakeEntity> findByMagnitudeLessThan(Float aFloat);

}
