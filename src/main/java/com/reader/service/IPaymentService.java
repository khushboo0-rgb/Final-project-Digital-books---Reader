package com.reader.service;

import java.util.List;
import com.reader.entity.Payment;
import com.reader.entity.PaymentReader;
import com.reader.payload.ResponsePayload;



public interface IPaymentService {

	Payment savePayment(Payment payment);
	
	List<PaymentReader> showListPurchasedBooks(String emailId);
	ResponsePayload refundMoney(String emailId,int paymentId);
	
	List<PaymentReader> showListPurchasedBooksByPaymentId(int PaymentId);
}