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
@Table(name="order_items")
public class OrderItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderItemsId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dish_id", unique = true)
	private Dish dish;
	private Integer qty;
	public Integer getOrderItemsId() {
		return orderItemsId;
	}
	public void setOrderItemsId(Integer orderItemsId) {
		this.orderItemsId = orderItemsId;
	}
	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
	
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
}
