package com.infy.api;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.UserAddressDTO;
import com.infy.dto.UsersDTO;
import com.infy.dto.WalletDTO;
import com.infy.service.RestaurantRecommendationService;
import com.infy.service.UserService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@Validated
@RequestMapping(value = "/UserAPI")
@CrossOrigin
public class UserAPI {
	
	
	@Autowired
	private UserService userService;
	
	static Logger logger = LogManager.getLogger(AdminAPI.class.getName());

//	@Autowired
//	private Environment environment;
//	
//	@Autowired
//	private RestaurantRecommendationService recommendationService;

	
	@PostMapping(value = "/userRegister")
	public ResponseEntity<String> registerUser( @Valid @RequestBody UsersDTO user) throws Exception {


		//Your code goes here
	
		   return new ResponseEntity<String>(this.userService.registerNewUser(user),HttpStatus.CREATED);
		
	}


	@PostMapping(value = "/userLogin")
	public ResponseEntity<UsersDTO> authenticateUser(@RequestBody UsersDTO user) throws Exception {

		//Your code goes here
		UsersDTO usersDTO = this.userService.authenticateUser(user.getContactNumber(), user.getPassword());
		
		   return new ResponseEntity<UsersDTO>(usersDTO,HttpStatus.OK);
	}
	
	@PostMapping(value = "/addAddress/{userId}")
	public ResponseEntity<String> addAddress(@Valid @RequestBody UserAddressDTO address,@PathVariable Integer userId) throws Exception {
		
		//Your code goes here
		this.userService.addNewAddress(address, userId).toString();
		String message="Address added successfully!";
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/updateAddress/{userId}")
	public ResponseEntity<String> updateAddress(@Valid @RequestBody UserAddressDTO address, @PathVariable Integer userId) throws Exception {

		//Your code goes here
		
		   return new ResponseEntity<String>(this.userService.updateAddress(address, userId),HttpStatus.ACCEPTED);

	}

	
	@DeleteMapping(value = "/deleteAddress/{addressId}/{userId}")
	public ResponseEntity<String> deleteAddress(@PathVariable Integer addressId,@PathVariable Integer userId) throws Exception {

		//Your code goes here
		   this.userService.deleteAddress(addressId, userId);
		   return new ResponseEntity<String>("Address has been successfully removed from your address book.",HttpStatus.OK);
		

	}
	@GetMapping(value = "getAddressList/{userId}")
	public ResponseEntity<List<UserAddressDTO>> getAddressList( @PathVariable Integer userId) throws Exception{
		
		//Your code goes here
//          this.userService.getAddressList(userId);
		   return  new ResponseEntity<List<UserAddressDTO>>(this.userService.getAddressList(userId),HttpStatus.OK);
	}
	@GetMapping(value = "updateWalletBalance/{topUpAmount}/{userId}")
	public ResponseEntity<WalletDTO> updateWalletBalance( @PathVariable @Positive Integer topUpAmount, @PathVariable Integer userId) throws Exception{
		
		
		return new ResponseEntity<WalletDTO>(this.userService.updateWalletBalance(topUpAmount, userId),HttpStatus.OK);
		
	}
	
	

}
