package com.paidclinic.repository;

import com.paidclinic.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    Product getProductsByTitle(String name);
}
