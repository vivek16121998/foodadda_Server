package com.infy.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="coupon")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer couponId;
	private String couponCode;
	private Integer minimumBill;
	private Integer maximumRedemption;
	private Date startDate;
	private Date endDate;


	public Integer getCouponId() {
		return couponId;
	}
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	
	public Integer getMinimumBill() {
		return minimumBill;
	}
	public void setMinimumBill(Integer minimumBill) {
		this.minimumBill = minimumBill;
	}
	public Integer getMaximumRedemption() {
		return maximumRedemption;
	}
	public void setMaximumRedemption(Integer maximumRedemption) {
		this.maximumRedemption = maximumRedemption;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
