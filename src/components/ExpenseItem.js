import React from "react";
import "./ExpenseItem.css";

export default function ExpenseItem({ expense, onDelete, onEdit }) {
	return (
		<div className="expense-item">
			<div>
				<h4>{expense.title}</h4>
				<p>₹ {expense.amount}</p>
				<p>{expense.category}</p>
				<p>{expense.date}</p>
				<small>{expense.notes}</small>
			</div>

			<div className="btn-group">
				<button className="edit-btn" onClick={() => onEdit(expense)}>
					Edit
				</button>
				<button className="delete-btn" onClick={() => onDelete(expense.id)}>
					Delete
				</button>
			</div>
		</div>
	);
}
