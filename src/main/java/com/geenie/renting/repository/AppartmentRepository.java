package com.geenie.renting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geenie.renting.beans.Appartment;

@Repository
public interface AppartmentRepository extends CrudRepository<Appartment, Long> {

}
