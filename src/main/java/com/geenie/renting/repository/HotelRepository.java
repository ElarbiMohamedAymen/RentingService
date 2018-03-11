package com.geenie.renting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geenie.renting.beans.Hotel;


@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {
	// TODO
}
