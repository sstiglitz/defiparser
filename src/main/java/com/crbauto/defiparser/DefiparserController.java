package com.crbauto.defiparser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crbauto.defiparser.services.DefiparserService;

@RestController
public class DefiparserController {

	@Autowired
	DefiparserService defiparserService;

	@RequestMapping(path = "/defi", method = RequestMethod.POST, consumes = "text/plain")
	public void processDefiXml(@RequestBody String defiXmlStr) {
		
		defiparserService.processDefiXml(defiXmlStr);
		
	}
	
}
