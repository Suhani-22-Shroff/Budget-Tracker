import React, { useState, useEffect } from "react";
import "./ExpenseForm.css";

export default function ExpenseForm({ onSubmit, editingExpense }) {
	const [form, setForm] = useState({
		title: "",
		amount: "",
		category: "",
		date: "",
		notes: "",
	});

	useEffect(() => {
		if (editingExpense) {
			setForm(editingExpense);
		}
	}, [editingExpense]);

	const handleChange = (e) => {
		setForm({ ...form, [e.target.name]: e.target.value });
	};

	const submitForm = (e) => {
		e.preventDefault();
		onSubmit(form);
		setForm({
			title: "",
			amount: "",
			category: "",
			date: "",
			notes: "",
		});
	};

	return (
		<form className="expense-form" onSubmit={submitForm}>
			<h3>{editingExpense ? "Update Expense" : "Add Expense"}</h3>

			<input
				type="text"
				name="title"
				placeholder="Title"
				value={form.title}
				onChange={handleChange}
				required
			/>

			<input
				type="number"
				name="amount"
				placeholder="Amount"
				value={form.amount}
				onChange={handleChange}
				required
			/>

			<input
				type="text"
				name="category"
				placeholder="Category"
				value={form.category}
				onChange={handleChange}
				required
			/>

			<input
				type="date"
				name="date"
				value={form.date}
				onChange={handleChange}
				required
			/>

			<textarea
				name="notes"
				placeholder="Notes"
				value={form.notes}
				onChange={handleChange}
			></textarea>

			<button type="submit" className="submit-btn">
				{editingExpense ? "Update" : "Add"}
			</button>
		</form>
	);
}
