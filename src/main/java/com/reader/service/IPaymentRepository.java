package com.reader.service;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reader.entity.Payment;



public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
	
	@Query(value="select b.image,b.title,b.price,b.active,p.total_amount,p.total_number,p.created_at,p.payment_id,p.refunded from book b inner join payment p on b.book_id=p.book_id where p.author_email=?1",nativeQuery = true)
	List<Object[]> showListPurchasedBooks(String emailId);
	
	@Query(value = "select * from payment where payment_id=?2 and author_email=?1",nativeQuery = true)
	Payment refundAmount(String emailId,int paymentId);

	@Query(value="select b.image,b.title,b.price,b.active,p.total_amount,p.total_number,p.created_at,p.payment_id,p.refunded from book b inner join payment p on b.book_id=p.book_id where p.payment_id=?1",nativeQuery = true)
	List<Object[]> showListPurchasedBooksByPaymentId(int paymentId);
}