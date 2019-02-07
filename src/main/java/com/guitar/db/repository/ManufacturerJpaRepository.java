package com.guitar.db.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.guitar.db.model.Manufacturer;

@Repository("manufacturerJpaRepository")
public interface ManufacturerJpaRepository extends JpaRepository<Manufacturer, Long> {

	List<Manufacturer> findByFoundedDateBefore(Date date);

	Manufacturer findFirstByNameStartingWith(String name);
	
	List<Manufacturer> findByActiveTrue();
	
	List<Manufacturer> findByActiveFalse();
	
	@Query(name="Manufacturer.getAllThatSellAcoustics")
	List<Manufacturer> nativeQueryAllThatSellsModelType(String modelType);

}
