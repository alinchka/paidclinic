package com.paidclinic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_name", nullable=false, length=25)
    private String name;
    @Column(name="date_birth", nullable=false, length=10)
    private String dateBirth;
    @Column(name="email", nullable=false, length=25)
    private String email;
    @Column(nullable=false)
    private String password;

    @OneToMany
    private List<Order> orders;
}

