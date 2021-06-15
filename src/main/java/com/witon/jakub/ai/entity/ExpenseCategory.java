package com.witon.jakub.ai.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Entity
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String categoryName;
    String description;
    @OneToMany(mappedBy = "expenseCategory")
    Set<Expense> expenses;
    @OneToMany(mappedBy = "expenseCategory")
    Set<ExpenseSubcategory> subcategories;

}
