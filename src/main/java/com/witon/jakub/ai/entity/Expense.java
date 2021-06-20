package com.witon.jakub.ai.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;


@Entity(name="Wydatki")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal price;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "Budżet_id")
    Budget budget;
    @ManyToOne
    @JoinColumn(name="Kategoria_wydatków_id")
    ExpenseCategory expenseCategory;

}
