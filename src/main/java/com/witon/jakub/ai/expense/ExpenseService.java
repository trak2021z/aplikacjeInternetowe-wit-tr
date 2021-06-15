package com.witon.jakub.ai.expense;

import com.witon.jakub.ai.entity.Expense;
import com.witon.jakub.ai.entity.ExpenseCategory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ExpenseCategory expenseCategory;
    public void loadExpensesByDate(LocalDate start, LocalDate end) {
        expenseRepository.findExpensesByDateIsBetween(start,end);
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

}
