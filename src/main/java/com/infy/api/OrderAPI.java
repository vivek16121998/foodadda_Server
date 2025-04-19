package com.infy.api;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infy.dto.OrdersDTO;
import com.infy.dto.PlaceOrderDTO;
import com.infy.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("orderAPI")
public class OrderAPI {
	
	@Autowired
	private OrderService orderService;

	
	static Logger logger = LogManager.getLogger(OrderAPI.class.getName());
	
	@GetMapping(value = "viewAllOrders/{userId}")
	public ResponseEntity<List<OrdersDTO>> viewAllOrders(@PathVariable Integer userId) throws Exception{
		
			logger.info("FETCHING ALL Orders");
			List<OrdersDTO> ordersList = orderService.viewOrders(userId);
			return new ResponseEntity<List<OrdersDTO>>(ordersList, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "getRestaurantName/{dishId}")
	public ResponseEntity<List<String>> getRestaurantName(@PathVariable List<Integer> dishId) throws Exception{
	
			logger.info("FETCHING ALL Restaurant");
			List<String> restaurantName = orderService.restaurantNames(dishId);
			return new ResponseEntity<List<String>>(restaurantName, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/newOrder/{userId}")
	public ResponseEntity<PlaceOrderDTO> newOrderByCustomer(@PathVariable Integer userId,
			@RequestBody OrdersDTO order) throws Exception{
	
			logger.info("FETCHING ALL Orders");
			PlaceOrderDTO result = orderService.placeAnOrder(userId, order);
			
			return new ResponseEntity<PlaceOrderDTO>(result, HttpStatus.OK);
		
	}

}
