package com.rhmtech.paymentservice.api.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhmtech.paymentservice.api.model.Payment;
import com.rhmtech.paymentservice.api.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentService service;
  @PostMapping("/dopament")
	public Payment DoPayment(@RequestBody Payment payment) {
		return service.DoPayment(payment);

	}

}
