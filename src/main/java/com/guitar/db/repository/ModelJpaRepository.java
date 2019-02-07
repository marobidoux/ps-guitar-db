package com.guitar.db.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.guitar.db.model.Model;

@Repository("modelJpaRepository")
public interface ModelJpaRepository extends JpaRepository<Model, Long>, ModelJpaRepositoryCustom {

	List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal lowest, BigDecimal highest);

	@Query("select m from Model m where m.price >= :lowest and m.price <= :highest and m.woodType like :wood")
	Page<Model> queryByPriceRangeAndWoodType(@Param("lowest") BigDecimal lowest, @Param("highest") BigDecimal highest,
			@Param("wood") String wood, Pageable page);

	List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqualAndWoodTypeContains(BigDecimal lowest,
			BigDecimal highest, String wood);

	List<Model> findByModelTypeNameIn(List<String> types);

//	@Query(name = "Model.findAllModelsByType")
//	List<Model> queryByModelTypeName(@Param("name") String typeName);
	
	List<Model> findAllModelsByType(@Param("name") String typeName);


}
