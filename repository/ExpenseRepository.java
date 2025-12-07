package com.budget.budget_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.budget.budget_tracker.model.Expense;

@Repository

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
