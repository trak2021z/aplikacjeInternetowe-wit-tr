package com.witon.jakub.ai.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity(name="Wydatki")
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal price;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "Budżet_id")
    Budget budget;
    @ManyToOne
    @JoinColumn(name="Kategoria_wydatków_id")
    ExpenseCategory expenseCategory;

}
