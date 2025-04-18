package com.infy.api;

import java.util.List;



import org.springframework.http.ResponseEntity;



import com.infy.dto.RestaurantDTO;
import com.infy.service.RestaurantRecommendationService;


public class RestaurantRecommendationAPI {


	
	private RestaurantRecommendationService recommendationService;
	

	
	
	
	public ResponseEntity<List<RestaurantDTO>> getRecommendationByArea(String area) throws Exception{

	
		//Your code goes here
		   return null;
			
	}
	
}
