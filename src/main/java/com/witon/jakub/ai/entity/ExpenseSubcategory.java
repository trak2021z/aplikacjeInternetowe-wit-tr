package com.witon.jakub.ai.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="Podkategoria")
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseSubcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String categoryName;
    String description;
    @ManyToOne
    @JoinColumn(name = "Kategoria_wydatków_id")
    ExpenseCategory expenseCategory;

}
