package Controller;

import Model.Expense;
import Service.ExpenseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/update")
public class UpdateExpController extends HttpServlet {
    ExpenseService expenseService = new ExpenseService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ExpenseId = Integer.parseInt(request.getParameter("id"));
        String ExpenseRemark = request.getParameter("remark");
        int ExpenseAmount = Integer.parseInt(request.getParameter("amount"));
        String PaymentMode = request.getParameter("payment_mode");
        LocalDateTime Time = LocalDateTime.parse(request.getParameter("time"));

        Expense expense = Expense.builder()
                .ExpenseId(ExpenseId)
                .ExpenseRemark(ExpenseRemark)
                .ExpenseAmount(ExpenseAmount)
                .PaymentMode(PaymentMode)
                .Time(Time)
                .build();
        expenseService.addExpense(expense);

        PrintWriter writer = response.getWriter();
        System.out.println("Expense updated successfully");
    }
}
