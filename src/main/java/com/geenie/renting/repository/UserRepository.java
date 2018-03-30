package com.geenie.renting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geenie.renting.beans.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

//	@QUERY("FROM USER U JOIN A.CATEGORY C WHERE C.NAME=:CATEGORYNAME")
//	PUBLIC ITERABLE<AUCTION> FINDBYCATEGORY(@PARAM("CATEGORYNAME") STRING CATEGORYNAME);
}
