package com.witon.jakub.ai.expense;

import com.witon.jakub.ai.entity.Expense;
import com.witon.jakub.ai.entity.ExpenseCategory;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense,Long> {
    List<Expense> findExpensesByDateIsBetween(LocalDate start, LocalDate end);
    List<Expense> findExpensesByExpenseCategory(ExpenseCategory category);
    List<Expense> findExpensesByDateIsBetweenAndExpenseCategory(LocalDate start, LocalDate end, ExpenseCategory category);
}
