package com.geenie.renting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geenie.renting.beans.Stay;
import com.geenie.renting.repository.StayRepository;
import com.geenie.renting.service.interfaces.IStayMySQLService;

@Service
public class StayMySQLServiceImpl implements IStayMySQLService {

	@Autowired
	private StayRepository stayRepository;
	
	@Override
	public void addStay(Stay stay) {
		stayRepository.save(stay);
	}

}
