package com.budget.budget_tracker.model;

import java.time.LocalDate;

import jakarta.persistence.*;
// import lombok.Data;

// @Data
@Entity

public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private Double amount;
    private String category;
    private LocalDate date;
    private String notes;

    // non- parameterized constructor
    public Expense() {
    }

    // parameterized constructor
    public Expense(String title, Double amount, String category, LocalDate date, String notes) {
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.notes = notes;
    }

    // getters setter

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Expense [id=" + id + ", title=" + title + ", amount=" + amount + ", category=" + category + ", date="
                + date + ", notes=" + notes + "]";
    }

}
