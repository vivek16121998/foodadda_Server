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
@Table(name="dish_rating")
public class DishRating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dishRatingId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dish_id", unique = true)
	private Dish dish;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID", unique = true)
	private Users user;
	private Integer rating;
	public Integer getDishRatingId() {
		return dishRatingId;
	}
	public void setDishRatingId(Integer dishRatingId) {
		this.dishRatingId = dishRatingId;
	}
	
	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
