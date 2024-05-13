package com.paidclinic.repository;

import com.paidclinic.entity.Order;
import com.paidclinic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>
{
    Optional<User> findUserByName(String username);
    User getUserByName(String username);
    boolean existsByName(String username);
}



