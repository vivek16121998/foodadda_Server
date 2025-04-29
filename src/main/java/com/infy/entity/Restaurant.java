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
@Table(name="restaurant")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurantId;
	private String restaurantName;
	private String restaurantContact;
	private String restaurantType;
	private String addressLine1;
	private String area;
	private String city;
	private String resState;
	private Integer pincode;
	private String approvalStatus;
	private Double avgRating;
	private String photoUrls;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "restaurant_id")
	private List<Dish> dishes;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id", unique = true)
	private RestaurantTransaction transaction;
	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantContact() {
		return restaurantContact;
	}
	public void setRestaurantContact(String restaurantContact) {
		this.restaurantContact = restaurantContact;
	}
	public String getRestaurantType() {
		return restaurantType;
	}
	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String adressLine1) {
		this.addressLine1 = adressLine1;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getResState() {
		return resState;
	}
	public void setResState(String resState) {
		this.resState = resState;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public List<Dish> getDishes() {
		return dishes;
	}
	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}
	public String getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(String photoUrls) {
		this.photoUrls = photoUrls;
	}
	public RestaurantTransaction getTransaction() {
		return transaction;
	}
	public void setTransaction(RestaurantTransaction transaction) {
		this.transaction = transaction;
	}

	

}
