package com.example.demoearthquake.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EarthquakeRepo extends JpaRepository<EarthQuakeEntity, Integer> {


}
