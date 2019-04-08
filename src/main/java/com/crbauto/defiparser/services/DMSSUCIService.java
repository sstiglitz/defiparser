package com.crbauto.defiparser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crbauto.defiparser.entities.DMSSUCI;
import com.crbauto.defiparser.repositories.DMSSUCIRepository;

@Service
public class DMSSUCIService {

	@Autowired
	DMSSUCIRepository dmssuciRepository;
	
	public DMSSUCI getDMSSUCIById(Long id) {
		return dmssuciRepository.findById(id).get();
	}
	
}
