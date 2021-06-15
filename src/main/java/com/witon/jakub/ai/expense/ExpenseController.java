package com.witon.jakub.ai.expense;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ExpenseController {
private final ExpenseService expenseService;

@GetMapping("/expenses")
    public String listAllExpenses(Model model) {
    return "expense-list";
}
@GetMapping("/addexpense")
    public String addExpense() {
    return "add-expense";
}
}
