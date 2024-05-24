package Controller;

import Service.ExpenseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/delete")
public class DeleteExpController extends HttpServlet {
    ExpenseService expenseService = new ExpenseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ExpenseId = Integer.parseInt(req.getParameter("id"));
        expenseService.deleteExpense(ExpenseId);
        PrintWriter writer=resp.getWriter();
        writer.println("Expense deleted Successfully");
    }
}
