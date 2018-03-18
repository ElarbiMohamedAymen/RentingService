package com.geenie.renting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geenie.renting.beans.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
