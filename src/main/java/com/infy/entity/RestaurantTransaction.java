package com.infy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="restaurant_transaction")
public class RestaurantTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurantTransactionId;
	private Integer restaurantOrderCounter;
	private Integer restaurantApproxCost;
	private Boolean restaurantStatus;
	
	public Integer getRestaurantTransactionId() {
		return restaurantTransactionId;
	}
	public void setRestaurantTransactionId(Integer restaurantTransactionId) {
		this.restaurantTransactionId = restaurantTransactionId;
	}
	public Integer getRestaurantOrderCounter() {
		return restaurantOrderCounter;
	}
	public void setRestaurantOrderCounter(Integer restaurantOrderCounter) {
		this.restaurantOrderCounter = restaurantOrderCounter;
	}
	public Integer getRestaurantApproxCost() {
		return restaurantApproxCost;
	}
	public void setRestaurantApproxCost(Integer restaurantApproxCost) {
		this.restaurantApproxCost = restaurantApproxCost;
	}
	public Boolean getRestaurantStatus() {
		return restaurantStatus;
	}
	public void setRestaurantStatus(Boolean restaurantStatus) {
		this.restaurantStatus = restaurantStatus;
	}
	
}
