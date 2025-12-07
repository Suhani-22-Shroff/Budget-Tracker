package com.budget.budget_tracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budget.budget_tracker.model.Expense;
import com.budget.budget_tracker.service.ExpenseServiceImpl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "http://localhost:3000")

public class ExpenseController {

    private final ExpenseServiceImpl expenseServiceImpl;

    // constructor injection
    public ExpenseController(ExpenseServiceImpl expenseServiceImpl) {
        this.expenseServiceImpl = expenseServiceImpl;
    }

    // create
    @PostMapping("/created")

    // TODO: process POST request

    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        Expense createdExpense = expenseServiceImpl.addExpense(expense);
        return new ResponseEntity<>(createdExpense, HttpStatus.CREATED); // 201
    }

    // read
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseServiceImpl.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK); // 200
    }
    // read

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Expense expense = expenseServiceImpl.getExpenseById(id);
        return new ResponseEntity<>(expense, HttpStatus.OK); // 200
    }

    // update

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        Expense updatedExpense = expenseServiceImpl.updateExpense(id, expense);

        if (updatedExpense == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
        }
        return new ResponseEntity<>(updatedExpense, HttpStatus.OK); // 200
    }

    // delete

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseServiceImpl.deleteExpense(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
    }

}
