package com.reader.entity;

import java.util.Date;

public class PaymentReader {
	
	private String image;
	private String title;
	private int price;
	private boolean active;
	private int paymentId;
	private int totalAmount;
	private int totalNumber;
	private Date created_at;
	private boolean refunded;
	@Override
	public String toString() {
		return "PaymentReader [image=" + image + ", title=" + title + ", price=" + price + ", active=" + active
				+ ", paymentId=" + paymentId + ", totalAmount=" + totalAmount + ", totalNumber=" + totalNumber
				+ ", created_at=" + created_at + ", refunded=" + refunded + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public PaymentReader(String image, String title, int price, boolean active, int paymentId, int totalAmount,
			int totalNumber, Date created_at, boolean refunded) {
		super();
		this.image = image;
		this.title = title;
		this.price = price;
		this.active = active;
		this.paymentId = paymentId;
		this.totalAmount = totalAmount;
		this.totalNumber = totalNumber;
		this.created_at = created_at;
		this.refunded = refunded;
	}
	public PaymentReader() {
		super();
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public boolean isRefunded() {
		return refunded;
	}
	public void setRefunded(boolean refunded) {
		this.refunded = refunded;
	}
	
	
	
}