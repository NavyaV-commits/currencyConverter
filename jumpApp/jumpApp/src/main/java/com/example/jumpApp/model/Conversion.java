package com.example.jumpApp.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Conversion {

	@Id
	@GeneratedValue
	private long id;
	
	private Double usdAmount;
	private String targetCurrency;
	private Double  rate;
	private Double convertedAmount;
	private LocalDateTime createdAt = LocalDateTime.now();
	public Double getUsdAmount() {
		return usdAmount;
	}
	public void setUsdAmount(Double usdAmount) {
		this.usdAmount = usdAmount;
	}
	public String getTargetCurrency() {
		return targetCurrency;
	}
	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Double getConvertedAmount() {
		return convertedAmount;
	}
	public void setConvertedAmount(Double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}
