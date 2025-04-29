package com.infy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="wallet")
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer walletId;
	private Float availableAmount;
	public Integer getWalletId() {
		return walletId;
	}
	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}
	public Float getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(Float availableAmount) {
		this.availableAmount = availableAmount;
	}
	
	
}
