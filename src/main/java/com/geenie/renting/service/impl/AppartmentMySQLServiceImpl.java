package com.geenie.renting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.geenie.renting.beans.Appartment;
import com.geenie.renting.repository.AppartmentRepository;
import com.geenie.renting.service.interfaces.IAppartmentMySQLService;

public class AppartmentMySQLServiceImpl implements IAppartmentMySQLService {

	@Autowired
	private AppartmentRepository appartmentRepository;
	
	@Override
	public void addAppartment(Appartment appartment) {
		appartmentRepository.save(appartment);	
	}

}
