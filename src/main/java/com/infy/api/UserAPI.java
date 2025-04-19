package com.infy.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infy.dto.UserAddressDTO;
import com.infy.dto.UsersDTO;
import com.infy.service.RestaurantRecommendationService;
import com.infy.service.UserService;

@Controller
@Validated
@RequestMapping(value = "/UserAPI")
@CrossOrigin
public class UserAPI {
	
	
	@Autowired
	private UserService userService;

	@Autowired
	private Environment environment;
	
	@Autowired
	private RestaurantRecommendationService recommendationService;

	
	
	public ResponseEntity<String> registerUser(UsersDTO user) throws Exception {


		//Your code goes here
		   return null;
		
	}


	@PostMapping(value = "/userLogin")
	public ResponseEntity<UsersDTO> authenticateUser( @RequestBody UsersDTO user) throws Exception {

		//Your code goes here
		UsersDTO usersDTO = this.userService.authenticateUser(user.getContactNumber(), user.getPassword());
		
		   return new ResponseEntity<UsersDTO>(usersDTO,HttpStatus.OK);
	}
	
	
	public ResponseEntity<Integer> addAddress(UserAddressDTO address,Integer userId) throws Exception {
		
		//Your code goes here
		   return null;
	}
	
	
	public ResponseEntity<String> updateAddress(UserAddressDTO address, Integer userId) throws Exception {

		//Your code goes here
		   return null;

	}

	
	
	public ResponseEntity<String> deleteAddress(Integer addressId, Integer userId) throws Exception {

		//Your code goes here
		   return null;
		

	}
	@GetMapping(value = "hello")
	public ResponseEntity<String> getAddressList(Integer userId) throws Exception{
		
		//Your code goes here
		String str="Hi Vivek Kumar";
		   return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	
	

}
