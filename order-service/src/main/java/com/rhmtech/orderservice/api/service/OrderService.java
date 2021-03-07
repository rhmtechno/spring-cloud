package com.rhmtech.orderservice.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rhmtech.orderservice.api.common.Payment;
import com.rhmtech.orderservice.api.common.TransactionRequest;
import com.rhmtech.orderservice.api.common.TransactionResponse;
import com.rhmtech.orderservice.api.model.Order;
import com.rhmtech.orderservice.api.repo.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private RestTemplate template;

	public TransactionResponse SaveOrder(TransactionRequest request) {
		String response = "";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());

		// Rest call
		Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/dopament", payment, Payment.class);
		response = paymentResponse.getPaymentstatus().equals("success") ? "payment processing and order placed"
				: "There is a failure in payment api,Order added to cart";
		orderRepository.save(order);
		return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);

	}

}
