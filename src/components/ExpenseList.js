import React, { useEffect, useState } from "react";
import api from "../api/axiosConfig";
import ExpenseItem from "./ExpenseItem";
import ExpenseForm from "./ExpenseForm";
import "./ExpenseList.css";

export default function ExpenseList() {
	const [expenses, setExpenses] = useState([]);
	const [editingExpense, setEditingExpense] = useState(null);

	// Load all expenses from backend
	const fetchExpenses = async () => {
		const response = await api.get("/");
		setExpenses(response.data);
	};

	useEffect(() => {
		fetchExpenses();
	}, []);

	// ADD or UPDATE Expense
	const handleSubmit = async (expense) => {
		if (editingExpense) {
			await api.put(`/${editingExpense.id}`, expense);
		} else {
			await api.post("/created", expense);
		}

		fetchExpenses();
		setEditingExpense(null);
	};

	// DELETE Expense
	const handleDelete = async (id) => {
		await api.delete(`/${id}`);
		fetchExpenses();
	};

	return (
		<div className="expense-container">
			<ExpenseForm onSubmit={handleSubmit} editingExpense={editingExpense} />

			<h2>Your Expenses</h2>

			{expenses.map((exp) => (
				<ExpenseItem
					key={exp.id}
					expense={exp}
					onDelete={handleDelete}
					onEdit={setEditingExpense}
				/>
			))}
		</div>
	);
}
