package com.witon.jakub.ai.expense;

import com.witon.jakub.ai.entity.Budget;
import com.witon.jakub.ai.entity.Expense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class ExpenseController {
private final ExpenseService expenseService;

@GetMapping("/expenses")
    public String listAllExpenses(Model model) {
    var expenses = expenseService.loadAllExpenses();
    model.addAttribute("expenses",expenses);
    return "expense-list";
}

@GetMapping("/addexpense")
    public String addExpense(Model model) {
    var categories = expenseService.loadAllCategories();
    model.addAttribute("categories",categories);
    LocalDate x = LocalDate.now();
    BigDecimal xd = BigDecimal.valueOf(10.5);
    Long id = 10L;
/*    Budget budget = new Budget(id);
    Expense expense = new Expense(id,xd,x);*/
    return "add-expense";
}

}
