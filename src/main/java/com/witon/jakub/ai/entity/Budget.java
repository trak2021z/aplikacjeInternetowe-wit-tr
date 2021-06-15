package com.witon.jakub.ai.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Budżet")
public class Budget
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    @OneToMany(mappedBy="budget")
    Set<User> users;
    @OneToMany(mappedBy="budget")
    Set<Expense> expenses;
}
