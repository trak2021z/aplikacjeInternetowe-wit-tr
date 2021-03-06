package com.witon.jakub.ai.budget;


import com.witon.jakub.ai.entity.Budget;
import com.witon.jakub.ai.entity.User;
import com.witon.jakub.ai.user.CustomUserDetails;
import com.witon.jakub.ai.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;

@Controller
@AllArgsConstructor
public class BudgetController {
    private final BudgetService budgetService;
    private final UserService userService;

    @GetMapping("/budget-list")
    @PostMapping("/budget-list")
    public String listUsers(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        if (userDetails.getUser().getBudget()!=null) {
            var budgetId = userDetails.getUser().getBudget().getId();
            var budgetUsers = budgetService.loadAllUsers(budgetId);
            budgetUsers.ifPresent(users -> model.addAttribute("budgetUsers", users));
            return "budget-list";
        }
        else {
            return "create-budget";
        }
    }
    @PostMapping("/create-budget")
    public String createBudget(Budget budget) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        var user = userDetails.getUser();
        var users = budget.getUsers();
        if(users!=null) {
            users.add(user);
        }
        else {
            users = new HashSet<>();
            users.add(user);
        }
        budget.setUsers(users);
        budgetService.createBudget(budget);
        userService.setBudgetToUser(user,budget);
        return "/budget-list";
    }
    @GetMapping("/associate-user")
    public String associateUserPage(Budget budget, String email) {

    return "associate-user";
    }
    @PostMapping("/associate-user")
    public String addUserToBudget(Budget budget, @RequestParam String email)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        var loggedInUseer = userDetails.getUser();
        budget = loggedInUseer.getBudget();
        var user = userService.findUserByEmail(email);
        userService.setBudgetToUser(user,budget);
        budgetService.addUserToBudget(budget,user);
        return "/budget-list";
    }

    @GetMapping("/create-budget")
    public String createBudgetPage(Budget budget) {

        return "/create-budget";
    }
}
