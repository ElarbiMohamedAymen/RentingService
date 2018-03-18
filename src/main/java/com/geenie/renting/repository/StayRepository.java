package com.geenie.renting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geenie.renting.beans.Stay;

@Repository
public interface StayRepository extends CrudRepository<Stay, Long> {

}
