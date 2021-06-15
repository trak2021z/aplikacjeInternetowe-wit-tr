package com.witon.jakub.ai.budget;

import com.witon.jakub.ai.entity.Budget;
import org.springframework.data.repository.CrudRepository;

public interface BudgetRepository extends CrudRepository<Budget,Long> {
}
