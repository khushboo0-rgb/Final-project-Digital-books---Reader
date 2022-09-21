package com.reader.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	private String authorEmail;
	private int bookId;
	private int totalAmount;
	private int totalNumber;
	private Date created_at;
	private boolean refunded;
	
	
	
	public Payment(int paymentId, String authorEmail, int bookId, int totalAmount, int totalNumber, Date created_at,
			boolean refunded) {
		super();
		this.paymentId = paymentId;
		this.authorEmail = authorEmail;
		this.bookId = bookId;
		this.totalAmount = totalAmount;
		this.totalNumber = totalNumber;
		this.created_at = created_at;
		this.refunded = refunded;
	}


	public Payment() {
		super();
	}
	

	public boolean isRefunded() {
		return refunded;
	}
	public void setRefunded(boolean refunded) {
		this.refunded = refunded;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getAuthorEmail() {
		return authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
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
	
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", authorEmail=" + authorEmail + ", bookId=" + bookId
				+ ", totalAmount=" + totalAmount + ", totalNumber=" + totalNumber + ", created_at=" + created_at
				+ ", refunded=" + refunded + "]";
	}

	
	
}