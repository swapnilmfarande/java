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
import java.util.List;

@WebServlet("/expense")
public class AddExpController extends HttpServlet {
    ExpenseService expenseService = new ExpenseService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Expense> expenseList = expenseService.getAllExpenses();
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<table border: 10px solid black><tr><th>ID</th> <th>Remark</th> <th>Amount</th> <th>Payment Mode</th> <th>Time</th></tr>");
        for (Expense expense : expenseList) {
            writer.println("<tr>");
            writer.println("<td>" + expense.getExpenseId() + "</td>");
            writer.println("<td>" + expense.getExpenseRemark() + "</td>");
            writer.println("<td>" + expense.getExpenseAmount() + "</td>");
            writer.println("<td>" + expense.getPaymentMode() + "</td>");
            writer.println("<td>" + expense.getTime() + "</td>");
            writer.println("</tr>");
        }
        writer.println("</table>");

    }

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
        System.out.println("Expense added successfully");
    }
}
