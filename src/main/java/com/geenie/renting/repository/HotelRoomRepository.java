package com.geenie.renting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geenie.renting.beans.HotelRoom;

@Repository
public interface HotelRoomRepository extends CrudRepository<HotelRoom, Long> {

}
