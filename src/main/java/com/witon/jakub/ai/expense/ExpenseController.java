package com.witon.jakub.ai.expense;

import com.witon.jakub.ai.entity.Budget;
import com.witon.jakub.ai.entity.Expense;
import com.witon.jakub.ai.entity.ExpenseCategory;
import com.witon.jakub.ai.user.CustomUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class ExpenseController {
private final ExpenseService expenseService;

@GetMapping("/expense-list")
    public String listAllExpenses(Model model) {
    var expenses = expenseService.loadAllExpenses();
    model.addAttribute("expenses",expenses);
    return "/expense-list";
}
    @PostMapping("/expense-list")
    public String listAllExpensesPage(Model model) {
        var expenses = expenseService.loadAllExpenses();
        model.addAttribute("expenses",expenses);
        return "/expense-list";
    }
@GetMapping("/add-expense")
    public String addExpense(Expense expense,Model model) {
    var categories = expenseService.loadAllCategories();
    model.addAttribute("categories",categories);
    return "add-expense";
}
@PostMapping("/add-expense")
    public String saveExpense(Expense expense, String expenseCategoryName, Model model) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
    var loggedInUseer = userDetails.getUser();
    var budget = loggedInUseer.getBudget();
    expense.setBudget(budget);
    var category = expenseService.loadExpenseCategoryByCategoryname(expenseCategoryName);
    expense.setExpenseCategory(category);
    var expenses = expenseService.loadAllExpenses();
    expenseService.saveExpense(expense);
    model.addAttribute("expenses",expenses);
    return "/expense-list";
}
@GetMapping("/edit-expense/{id}")
    public String updateExpensePage(@PathVariable("id") Long id, Model model) {
    System.out.println(id);
    Expense expense = expenseService.loadExpenseById(id);
    model.addAttribute("expense",expense);
    var categories = expenseService.loadAllCategories();
    model.addAttribute("categories",categories);
    return "/update-expense";
}
@PostMapping("/update-expense/{id}")
    public String updateExpense(Expense expense, String expenseCategoryName) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
    var loggedInUseer = userDetails.getUser();
    var budget = loggedInUseer.getBudget();
    expense.setBudget(budget);
    var category = expenseService.loadExpenseCategoryByCategoryname(expenseCategoryName);
    expense.setExpenseCategory(category);
    expenseService.saveExpense(expense);
    return "redirect:/expense-list";
}
@GetMapping("/delete-expense/{id}")
    public String deleteExpense(@PathVariable("id") Long id) {
    expenseService.deleteExpense(expenseService.loadExpenseById(id));
    return "redirect:/expense-list";
}
}


