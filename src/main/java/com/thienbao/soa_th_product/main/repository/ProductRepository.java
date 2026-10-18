package com.thienbao.soa_th_product.main.repository;

import com.thienbao.soa_th_product.main.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}