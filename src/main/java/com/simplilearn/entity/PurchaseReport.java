package com.simplilearn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="purchasereport")
public class PurchaseReport {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="purchase_id")
	private int purchaseId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="category")
	private String category;
	
	@Column(name="username")
	private String username;
	
	@Column(name="purchase_date")
	private Date date;

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
