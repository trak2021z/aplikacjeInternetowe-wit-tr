package com.witon.jakub.ai.expense;

import com.witon.jakub.ai.entity.ExpenseCategory;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseCategoryRepository extends CrudRepository<ExpenseCategory,Long> {
public ExpenseCategory findByCategoryName(String categoryName);
}
