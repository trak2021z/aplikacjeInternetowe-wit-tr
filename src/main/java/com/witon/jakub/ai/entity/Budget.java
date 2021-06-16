package com.witon.jakub.ai.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "budżet")
@Getter
@Setter
public class Budget
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String nazwa;
    @OneToMany(mappedBy="budget")
    Set<User> users;
    @OneToMany(mappedBy="budget")
    Set<Expense> expenses;
}
