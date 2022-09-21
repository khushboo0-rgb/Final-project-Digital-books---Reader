package com.reader.payload;

import com.reader.entity.Payment;

public class ResponsePayload {
	
	private int statusCode;
	private String message;
	private Object data;
	private Payment payment;
	
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public ResponsePayload(int statusCode, String message, Payment payment) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.payment = payment;
	}
	public ResponsePayload(int statusCode, String message, Object data) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}
	public ResponsePayload() {
		super();
	}
	public ResponsePayload(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}