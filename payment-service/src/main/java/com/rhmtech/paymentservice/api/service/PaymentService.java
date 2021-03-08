package com.rhmtech.paymentservice.api.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhmtech.paymentservice.api.model.Payment;
import com.rhmtech.paymentservice.api.repo.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	public Payment DoPayment(Payment payment) {
		payment.setPaymentstatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);

	}

	public String paymentProcessing() {
		// api should be 3rd party gateway(ssl-commerce,bikash,nagad..)
		return new Random().nextBoolean() ? "success" : "failed";
	}

	public Payment findPaymentHistoryByOrderId(int orderId) {
		return paymentRepository.findByOrderId(orderId);
	}

}
