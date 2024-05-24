package Service;

import Dao.ExpenseDao;
import Model.Expense;

import java.util.List;

public class ExpenseService {
    ExpenseDao expenseDao = new ExpenseDao();

    public void addExpense(Expense expense){
        expenseDao.addExpense(expense);
    }

    public void updateExpense(Expense expense){
        expenseDao.updateExpense(expense);
    }

    public void deleteExpense(int ExpenseId){
        expenseDao.deleteExpense(ExpenseId);
    }

    public List<Expense> getAllExpenses(){
        return expenseDao.getAllExpenses();
    }
}
