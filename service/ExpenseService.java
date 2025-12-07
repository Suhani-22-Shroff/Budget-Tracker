package com.budget.budget_tracker.service;

import java.util.List;

import com.budget.budget_tracker.model.Expense;

public interface ExpenseService {

    Expense addExpense(Expense expense);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    Expense updateExpense(Long id, Expense expense);

    void deleteExpense(Long id);
}
