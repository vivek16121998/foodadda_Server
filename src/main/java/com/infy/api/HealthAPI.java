package com.infy.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HealthAPI {
	
	static Logger logger = LogManager.getLogger(AdminAPI.class.getName());

	@GetMapping(value = "/")
	public ResponseEntity<String> Health() throws Exception{
		
		
			logger.info("checking health for load blancer");
			
			return new ResponseEntity<String>("Ok", HttpStatus.OK);
		
	}
}
