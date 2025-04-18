package com.infy.dto;

public class PlaceOrderDTO {

	private Integer OrderId;
	private Integer availableAmount;
	public Integer getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(Integer availableAmount) {
		this.availableAmount = availableAmount;
	}
	public Integer getOrderId() {
		return OrderId;
	}
	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}

}
