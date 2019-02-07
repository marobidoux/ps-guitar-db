package com.guitar.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guitar.db.model.Location;

@Repository("locationJpaRepository")
public interface LocationJpaRepository extends JpaRepository<Location, Long> {

	List<Location> findByStateStartingWithIgnoreCaseOrderByStateDesc(String stateName);
	
	
	List<Location> findByStateOrCountry(String stateName, String countryName);
	
	List<Location> findByStateAndCountry(String stateName, String countryName);

	List<Location> findByStateNot(String stateName);
	
	
}

