<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Expenses</title>
</head>
<body>
    <h2>Expenses</h2>
    <form action="/expenses/add" method="post">
        <div>
            <label>Category:</label>
            <input type="text" name="category" required>
        </div>
        <div>
            <label>Amount:</label>
            <input type="number" name="amount" step="0.01" required>
        </div>
        <div>
            <label>Comments:</label>
            <input type="text" name="comments">
        </div>
        <button type="submit">Add Expense</button>
    </form>

    <h3>Expense List</h3>
    <table>
        <thead>
            <tr>
                <th>Category</th>
                <th>Amount</th>
                <th>Comments</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="expense" items="${expenses}">
                <tr>
                    <td>${expense.category}</td>
                    <td>${expense.amount}</td>
                    <td>${expense.comments}</td>
                    <td>
                        <form action="/expenses/edit/${expense.id}"
