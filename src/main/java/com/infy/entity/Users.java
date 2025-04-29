package com.infy.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String emailId;
	private String contactNumber;
	private String password;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private List<Roles> roles;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private List<Restaurant> restaurants;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<UserAddress> addressList;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", unique = true)
	private Wallet wallet;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private List<UserLikes> userLikesList;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Orders> ordersList;
	

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	public List<UserAddress> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<UserAddress> addressList) {
		this.addressList = addressList;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	public List<UserLikes> getUserLikesList() {
		return userLikesList;
	}
	public void setUserLikesList(List<UserLikes> userLikesList) {
		this.userLikesList = userLikesList;
	}
	public List<Orders> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
	
	
}
