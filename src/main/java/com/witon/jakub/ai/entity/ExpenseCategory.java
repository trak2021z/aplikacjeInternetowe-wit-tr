package com.witon.jakub.ai.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Entity
@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
