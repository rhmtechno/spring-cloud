package com.rhmtech.orderservice.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rhmtech.orderservice.api.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
