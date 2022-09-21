package com.reader.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reader.entity.Payment;
import com.reader.entity.PaymentReader;
import com.reader.payload.ResponsePayload;



@Service
public class PaymentServiceImpl implements IPaymentService{
	
	@Autowired
	private IPaymentRepository paymentRepository;

	@Override
	public Payment savePayment(Payment payment) {
		System.out.println("khushupayment");
		return paymentRepository.save(payment);
	}

	@Override
	public List<PaymentReader> showListPurchasedBooks(String emailId) {
		List<Object[]>b=paymentRepository.showListPurchasedBooks(emailId);
		List<PaymentReader>list=new ArrayList<>();
		for(Object [] object:b) {
			PaymentReader payment=new PaymentReader();
			payment.setImage((String)object[0]);
			payment.setTitle((String)object[1]);
			payment.setPrice((int)object[2]);
			payment.setActive((boolean)object[3]);
			payment.setTotalAmount((int)object[4]);
			payment.setTotalNumber((int)object[5]);
			payment.setCreated_at((Date)object[6]);
			payment.setPaymentId((int)object[7]);
			payment.setRefunded((boolean)object[8]);
			list.add(payment);
		}
		return list;
	}
	
	@Override
	public List<PaymentReader> showListPurchasedBooksByPaymentId(int paymentId) {
		List<Object[]>b=paymentRepository.showListPurchasedBooksByPaymentId(paymentId);
		List<PaymentReader>list=new ArrayList<>();
		for(Object [] object:b) {
			PaymentReader payment=new PaymentReader();
			payment.setImage((String)object[0]);
			payment.setTitle((String)object[1]);
			payment.setPrice((int)object[2]);
			payment.setActive((boolean)object[3]);
			payment.setTotalAmount((int)object[4]);
			payment.setTotalNumber((int)object[5]);
			payment.setCreated_at((Date)object[6]);
			payment.setPaymentId((int)object[7]);
			payment.setRefunded((boolean)object[8]);
			list.add(payment);
		}
		return list;
	}
	
	
	@Override
	public ResponsePayload refundMoney(String emailId, int paymentId) {
		Payment pay=paymentRepository.refundAmount(emailId, paymentId);
		if(pay.isRefunded()) {
			return new ResponsePayload(HttpStatus.SC_CONFLICT, "REFUND HAS BEEN INITIATED ALREADY , MIGHT TAKE TIME TO REFLECT IN BANK AC");
		}
		Date date=new Date();
		long ms=date.getTime()-pay.getCreated_at().getTime();
		long minute=ms/60000;
		if(minute<1440) {
			pay.setRefunded(true);
			paymentRepository.save(pay);
			return new ResponsePayload(HttpStatus.SC_ACCEPTED, "AMOUNT REFUND INITIATED ",pay);
		}else {
			return new ResponsePayload(HttpStatus.SC_BAD_REQUEST, "AMOUNT REFOUND REJECTED");
		}
	}
	
}