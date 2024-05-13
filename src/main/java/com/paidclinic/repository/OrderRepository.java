package com.paidclinic.repository;

import com.paidclinic.entity.Order;
import com.paidclinic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer>
{

}
