import React from "react";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import ExpenseList from "./components/ExpenseList";
import "./App.css";

function App() {
	return (
		<div className="main-app">
			<Navbar />
			<div className="content-wrapper">
				<h1 className="page-title">Budget Tracker</h1>
				<ExpenseList />
			</div>
			<Footer />
		</div>
	);
}

export default App;
