package com.paidclinic.service;

import com.paidclinic.entity.Order;
import com.paidclinic.entity.User;
import com.paidclinic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public User getUserByName(String userName)
    {
        return userRepository.getUserByName(userName);
    }

    public void addOrder(Order order, String name)
    {
        var user = getUserByName(name);
        user.getOrders().add(order);
        userRepository.save(user);
    }
}

