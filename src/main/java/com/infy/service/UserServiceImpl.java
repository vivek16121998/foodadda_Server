package com.infy.service;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.UserAddressDTO;
import com.infy.dto.UsersDTO;
import com.infy.dto.WalletDTO;
import com.infy.entity.Users;
import com.infy.entity.Wallet;
import com.infy.exception.FoodAddaException;
import com.infy.repository.UserAddressRepository;
import com.infy.repository.UsersRepository;
import com.infy.repository.WalletRepository;
import com.infy.utility.HashingUtility;


@Service(value = "UserService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private UserAddressRepository userAddressRepository;
	
	@Autowired
	private ModelMapper mapper;
    @Autowired
	private WalletRepository walletRepository;

	@Override
	public UsersDTO authenticateUser(String contactNumber, String password) throws Exception{
		
		//Your code goes here
		List<Users> users = userRepository.findByContactNumber(contactNumber);
		if(users.isEmpty()) {
			throw new FoodAddaException("UserService.INVALID_CREDENTIALS");
		}
		Users user = users.get(0);
		String hashPass = HashingUtility.getHashValue(password);
		if(!user.getPassword().equals(hashPass)) {
			throw new FoodAddaException("UserService.INVALID_CREDENTIALS");
		}
		List<Wallet> wallets = walletRepository.getUserId(user.getUserId());
		Wallet wallet = wallets.get(0);
		WalletDTO walletDTO = mapper.map(wallet, WalletDTO.class);
		UsersDTO userdto = mapper.map(user, UsersDTO.class);
		userdto.setWallet(walletDTO);
		return userdto;
	}
	
	@Override
	public String registerNewUser(UsersDTO user) throws Exception{
		
		//Your code goes here
				return null;
		}
			
	
	
	@Override
	public Integer addNewAddress(UserAddressDTO address, Integer userId) throws Exception {
		
		//Your code goes here
				return null;
	}

	@Override
	public String updateAddress(UserAddressDTO address, Integer userId) throws Exception {

		//Your code goes here
				return null;
	}
	
	@Override
	public void deleteAddress(Integer addressId, Integer userId) throws Exception {
			
		//Your code goes here
				
	}
}


