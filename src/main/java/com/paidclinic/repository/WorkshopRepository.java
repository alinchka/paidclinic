package com.paidclinic.repository;

import com.paidclinic.entity.Product;
import com.paidclinic.entity.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkshopRepository extends JpaRepository<Workshop, Integer>
{
    Workshop getWorkshopByProduct(Product product);
}
