package com.rhmtech.orderservice.api.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class Payment { 
		private int paymentId;
		private String paymentstatus;
		private String transactionId;
		private int orderId;
		private double amount;

	}


