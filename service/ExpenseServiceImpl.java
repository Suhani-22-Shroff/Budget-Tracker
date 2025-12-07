package com.budget.budget_tracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.budget.budget_tracker.model.Expense;
import com.budget.budget_tracker.repository.ExpenseRepository;

@Service

public class ExpenseServiceImpl implements ExpenseService {

    private final List<Expense> expenses = new ArrayList<>();

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense addExpense(Expense expense) {
        // TODO Auto-generated method stub

        expenses.add(expense);
        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        // TODO Auto-generated method stub
        return expenseRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Expense getExpenseById(Long id) {
        // TODO Auto-generated method stub
        return expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("expense not found with id" + id));
    }

    @Override
    public Expense updateExpense(Long id, Expense expense) {
        // TODO Auto-generated method stub

        Expense existingExpense = expenseRepository.findById(id).orElse(null);

        if (existingExpense == null) {
            return null;
        }

        // update fields
        existingExpense.setTitle(expense.getTitle());
        existingExpense.setAmount(expense.getAmount());
        existingExpense.setCategory(expense.getCategory());
        existingExpense.setDate(expense.getDate());
        existingExpense.setNotes(expense.getNotes());

        return expenseRepository.save(existingExpense);
    }

    @Override
    public void deleteExpense(Long id) {
        // TODO Auto-generated method stub

        expenseRepository.deleteById(id);

    }
}