package com.rhmtech.paymentservice.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PAYMENT_TB")
public class Payment {
	@Id
	@GeneratedValue
	private int paymentId;
	private String paymentstatus;
	private String transactionId;
	private int orderId;
	private int amount;

}
