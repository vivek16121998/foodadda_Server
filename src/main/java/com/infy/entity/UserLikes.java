package com.infy.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_likes")
public class UserLikes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer likeId;
	private String vegNonveg;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dish_id", unique = true)
	private Dish dish;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id", unique = true)
	private Restaurant restaurant;
	public Integer getLikeId() {
		return likeId;
	}
	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
	}
	public String getVegNonveg() {
		return vegNonveg;
	}
	public void setVegNonveg(String vegNonveg) {
		this.vegNonveg = vegNonveg;
	}
	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
