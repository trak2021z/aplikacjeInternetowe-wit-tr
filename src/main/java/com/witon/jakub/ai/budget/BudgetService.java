package com.witon.jakub.ai.budget;

import com.witon.jakub.ai.entity.Budget;
import com.witon.jakub.ai.entity.User;
import com.witon.jakub.ai.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class BudgetService {
private BudgetRepository budgetRepository;

public Optional<Set<User>> loadAllUsers(Long id) {
    var budget = budgetRepository.findById(id);
    Optional<Set<User>> users = Optional.of(budget.get().getUsers());
    return users;
}
public void createBudget(Budget budget) {
    budgetRepository.save(budget);
}
public void addUserToBudget(Budget budget, User user) {
    var users = budget.getUsers();
    users.add(user);
    budgetRepository.save(budget);
}
}
