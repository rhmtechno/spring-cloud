package com.rhmtech.orderservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhmtech.orderservice.api.common.TransactionRequest;
import com.rhmtech.orderservice.api.common.TransactionResponse;
import com.rhmtech.orderservice.api.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookorders")
	public TransactionResponse BookOrder(@RequestBody TransactionRequest request) {
		
		return orderService.SaveOrder(request);
		
	}

}
