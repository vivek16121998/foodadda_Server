package com.infy.service;


import java.util.List;

import com.infy.dto.UserAddressDTO;
import com.infy.dto.UsersDTO;
import com.infy.dto.WalletDTO;

public interface UserService {

	public UsersDTO authenticateUser(String contactNumber, String password) throws Exception;
	
	public String registerNewUser(UsersDTO user) throws Exception;
	
	public Integer addNewAddress(UserAddressDTO address, Integer userId) throws Exception;
	
	public String updateAddress(UserAddressDTO address, Integer userId) throws Exception;
	
	public void deleteAddress(Integer addressId, Integer userId) throws Exception;
	
	public List<UserAddressDTO> getAddressList(Integer userId) throws Exception;

	public WalletDTO updateWalletBalance(Integer topUpAmount, Integer userId) throws Exception;
}
