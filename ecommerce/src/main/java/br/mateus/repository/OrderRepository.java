package br.mateus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mateus.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
