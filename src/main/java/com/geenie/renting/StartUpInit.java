package com.geenie.renting;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geenie.renting.service.interfaces.IHotelMySQLService;

@Service
@Transactional
public class StartUpInit implements ApplicationRunner {

	
	@Autowired
	@Qualifier("hotelMySQLServiceImpl")
	IHotelMySQLService hotelService;
	
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		
	}
}
