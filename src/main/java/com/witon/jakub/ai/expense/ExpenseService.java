package com.witon.jakub.ai.expense;

import com.witon.jakub.ai.entity.Expense;
import com.witon.jakub.ai.entity.ExpenseCategory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ExpenseCategoryRepository expenseCategoryRepository;
    public void loadExpensesByDate(LocalDate start, LocalDate end) {
        expenseRepository.findExpensesByDateIsBetween(start,end);
    }

    public ExpenseCategory loadExpenseCategoryByCategoryname(String categoryName) {
        return expenseCategoryRepository.findByCategoryName(categoryName);
    }
    public List<Expense> loadExpensesByDateAndCategory(LocalDate start, LocalDate end, ExpenseCategory category) {
        return expenseRepository.findExpensesByDateIsBetweenAndExpenseCategory(start,end,category);
    }
    public List<Expense> loadExpensesByCategory(ExpenseCategory category) {
        return expenseRepository.findExpensesByExpenseCategory(category);
    }
    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }
    public void deleteExpense(Expense expense) {
        expenseRepository.delete(expense);
    }
    public List<Expense> loadAllExpenses() {
        return expenseRepository.findAllByOrderByDateDesc();
    }
    public List<ExpenseCategory> loadAllCategories() {
        return StreamSupport.stream(expenseCategoryRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
    public Expense loadExpenseById(Long id) {
        final var expense = expenseRepository.findById(id);
        return expense.orElseThrow(NoResultException::new);
    }
}
