package br.mateus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mateus.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
