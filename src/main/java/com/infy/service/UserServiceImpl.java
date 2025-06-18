package com.infy.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.Role;
import com.infy.dto.UserAddressDTO;
import com.infy.dto.UsersDTO;
import com.infy.dto.WalletDTO;
import com.infy.entity.Roles;
import com.infy.entity.UserAddress;
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
		
		
		UsersDTO userdto = mapper.map(user, UsersDTO.class);

		List<Wallet> wallets = walletRepository.getWalletByUserId(user.getUserId());
		Wallet wallet = wallets.get(0);
		WalletDTO walletDTO = mapper.map(wallet, WalletDTO.class);
		userdto.setWallet(walletDTO);
		userdto.setPassword("");
		return userdto;
	}
	
	@Override
	public String registerNewUser(UsersDTO user) throws Exception{
		
		//Your code goes here
		    List<Users> u1 = userRepository.findByContactNumber(user.getContactNumber());
		    if(!u1.isEmpty()) {
                   if(u1.get(0).getRoles().size()>=2) {
                	   
                	   throw new FoodAddaException("UserService.USER_ALREADY_EXISTS");
		    	    }
                   else if(u1.get(0).getRoles().get(0).getRoleType().equals(user.getRoles().get(0).getRoleType())) {
                	   throw new FoodAddaException("UserService.USER_ALREADY_EXISTS");
                   }
                   else {
                	   Users users = this.mapper.map(user, Users.class);
                	   Users userEntity = u1.get(0);
                	   List<Roles> joinedList =  userEntity.getRoles();
                       joinedList.addAll(users.getRoles());                  // add second list
                       userEntity.setRoles(joinedList);
                       Users userEntity1= userRepository.save(userEntity);
                       return "Congratulations! You have registered successfully with Used Id : "+userEntity1.getUserId().toString()+" as a "+user.getRoles().get(0).getRoleType();
                	   
                	   
                	   

                   }
 
		    					    		
		    }
		    Users users = this.mapper.map(user, Users.class);
		    String hashPass = HashingUtility.getHashValue(user.getPassword());
		    users.setPassword(hashPass);
		    Users UserEntity = userRepository.save(users);
		    Wallet wallet = new Wallet();
		    wallet.setAvailableAmount(10000f);
		    wallet.setUserId(UserEntity.getUserId());
		    walletRepository.save(wallet);
		
		  return "Congratulations! You have registered successfully with Used Id : "+UserEntity.getUserId().toString()+" as a "+user.getRoles().get(0).getRoleType();
		}
				
	@Override
	public Integer addNewAddress(UserAddressDTO address, Integer userId) throws Exception {
		
		//Your code goes here
		Optional<Users> users = userRepository.findById(userId);
		if(users.isEmpty()) {
			throw new FoodAddaException("UserService.USER_NOT_FOUND");
		}
		Users user = users.get();
		List<UserAddress> list = user.getAddressList();
		for(UserAddress userAddress:list) {
			if(userAddress.getUserAddressName().equalsIgnoreCase(address.getUserAddressName())) {
				throw new FoodAddaException("UserService.ADDRESS_NAME_ALREADY_EXISTS");
			}
		}
		list.add(this.mapper.map(address, UserAddress.class));
		user.setAddressList(list);
		Users userEntity = userRepository.save(user);
		
	   return userEntity.getAddressList().get(userEntity.getAddressList().size()-1).getUserAddressId();
	}

	@Override
	public String updateAddress(UserAddressDTO addressDTO, Integer userId) throws Exception {

		//Your code goes here
		Optional<Users> users = userRepository.findById(userId);
		if(users.isEmpty()) {
			throw new FoodAddaException("UserService.USER_NOT_FOUND");
		}
		Users user = users.get();
		List<UserAddress> list = user.getAddressList();
		if(list.isEmpty()) {
			throw new FoodAddaException("UserService.ADDRESS_NOT_FOUND");

		}
        for(UserAddress userAddress:list) {
        	if(userAddress.getUserAddressId()==addressDTO.getUserAddressId()) {	
        		UserAddress UserAddress = this.mapper.map(addressDTO, UserAddress.class);
        		this.userAddressRepository.save(UserAddress);
        	}
        }
        
        
		return "Address updated successfully";
	}
	
	@Override
	public void deleteAddress(Integer addressId, Integer userId) throws Exception {
			
		//Your code goes here
		Optional<Users> users = userRepository.findById(userId);
		if(users.isEmpty()) {
			throw new FoodAddaException("UserService.USER_NOT_FOUND");
		}
		Users user = users.get();
		List<UserAddress> list = user.getAddressList();
		if(list.isEmpty()) {
			throw new FoodAddaException("UserService.ADDRESS_NOT_FOUND");

		}
		
		List<UserAddress> updatedList = list.stream()
			    .filter(address -> address.getUserAddressId() != addressId)
			    .collect(Collectors.toList());
        if(updatedList.size()==list.size()) {
        	throw new FoodAddaException("UserService.ADDRESS_NOT_BELONG_TO_YOU");
        }
        if (list.size() == 1) {
		    throw new FoodAddaException("UserService.MINIMUM_ONE_ADDRESS_REQUIRED");
		}	    
		
		user.setAddressList(updatedList);
		
		userRepository.save(user);	
		this.userAddressRepository.deleteById(addressId);
	}

	@Override
	public List<UserAddressDTO> getAddressList(Integer userId) throws Exception {
		
		Optional<Users> users = userRepository.findById(userId);
		if(users.isEmpty()) {
			throw new FoodAddaException("UserService.USER_NOT_FOUND");
		}
		Users user = users.get();
		
		List<UserAddress> list = user.getAddressList();
		if(list.isEmpty()) {
			throw new FoodAddaException("UserService.ADDRESS_NOT_FOUND");

		}
		List<UserAddressDTO> UserAddressDTOList = new ArrayList<UserAddressDTO>();
		for(UserAddress userAddress:list) {
			UserAddressDTO userAddressDTO = this.mapper.map(userAddress, UserAddressDTO.class);
			UserAddressDTOList.add(userAddressDTO);
		}
		
		return UserAddressDTOList;
	}
	
	@Override
	public WalletDTO updateWalletBalance(Integer topUpAmount,Integer userId) throws Exception {

		List<Wallet> wallets = walletRepository.getWalletByUserId(userId);
		if(wallets.isEmpty()) {
			throw new FoodAddaException("UserService.USER_NOT_FOUND");
		}
		Wallet wallet = wallets.get(0);
		wallet.setAvailableAmount(wallet.getAvailableAmount()+topUpAmount);
		WalletDTO walletDTO = mapper.map(walletRepository.save(wallet), WalletDTO.class);
		System.out.print(walletDTO.getAvailableAmount());
		return walletDTO;
	}
}


