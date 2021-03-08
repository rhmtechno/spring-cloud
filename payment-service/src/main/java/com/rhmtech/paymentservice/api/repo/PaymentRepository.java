package com.rhmtech.paymentservice.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rhmtech.paymentservice.api.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	Payment findByOrderId(int orderId);

}
