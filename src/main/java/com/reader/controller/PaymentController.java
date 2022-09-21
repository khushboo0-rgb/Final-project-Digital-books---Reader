package com.reader.controller;

import java.util.Date;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reader.entity.Payment;
import com.reader.payload.ResponsePayload;

import com.reader.service.PaymentServiceImpl;


@RestController
@RequestMapping("payment")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

	


	@Autowired
	private PaymentServiceImpl paymentService;
	
	@GetMapping("/reader/{emailId}/purchasedbooks/{paymentId}")
	public ResponseEntity<?> payRefund(@PathVariable("emailId")String emailId,@PathVariable("paymentId")int paymentId){
		try {
		return ResponseEntity.ok(paymentService.refundMoney(emailId, paymentId));
		}catch(Exception ex) {
			return ResponseEntity.ok(new ResponsePayload(HttpStatus.SC_BAD_REQUEST, "SOMETHING WRONG"));
		}
	}
	
	
	@PostMapping("/books/payment/buy")
	public ResponseEntity<?> savePayment(@RequestBody Payment payment){
		try {
			Date date=new Date();
			payment.setCreated_at(date);
			Payment obj=paymentService.savePayment(payment);
			return ResponseEntity.ok(new ResponsePayload(HttpStatus.SC_ACCEPTED, "SUCCESS", obj));
		}catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
			return ResponseEntity.ok(new ResponsePayload(HttpStatus.SC_BAD_REQUEST, "SOMETHING WRONG"));
		}
	}
	
	@GetMapping("/readers/{emailId}")
	public ResponseEntity<?> showListOfPurchasedBooks(@PathVariable("emailId")String emailId){
		return ResponseEntity.ok(paymentService.showListPurchasedBooks(emailId));
	}
	
	@GetMapping("/readers/paymentId/{paymentId}")
	
	public ResponseEntity<?> showListOfPurchasedBooksBypaymentId(@PathVariable("paymentId") int  paymentId){
		System.out.println("khushu");
		return ResponseEntity.ok(paymentService.showListPurchasedBooksByPaymentId(paymentId));
	}
	
	
}