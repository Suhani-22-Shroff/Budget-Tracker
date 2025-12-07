import { render, screen } from "@testing-library/react";
import App from "./App";

test("renders expense tracker heading", () => {
	render(<App />);
	const headingElement = screen.getByText(/Expense Tracker/i);
	expect(headingElement).toBeInTheDocument();
});
