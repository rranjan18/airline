package com.ranjan.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranjan.airline.entity.AirlineSearchEntity;

public interface AirlineSearchRepository extends JpaRepository<AirlineSearchEntity, String> {

	// @Query(value = "SELECT searchEntityInstance FROM AirlineSearchEntity
	// searchEntityInstance "
	// + "WHERE searchEntityInstance.current=true AND
	// searchEntityInstance.active=true "
	// + "AND searchEntityInstance.goingTo = :goingTo AND
	// searchEntityInstance.departForm=:departForm")
	// List<AirlineSearchEntity> findSearchEntity(@Param("departForm") String
	// departForm,
	// @Param("goingTo") String goingTo);

}
