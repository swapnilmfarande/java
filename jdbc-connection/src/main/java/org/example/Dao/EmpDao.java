package org.example.Dao;

import org.example.Model.Employee;
import org.example.Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
    public void addEmployee(Employee employee){
        Connection connection = ConnectionUtil.getConnection();
        String query = "insert into manager_app.Employees(empId,empName,empCity,empPhone)values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,employee.getEmployeeId());
            preparedStatement.setString(2,employee.getEmployeeName());
            preparedStatement.setString(3,employee.getEmployeeCity());
            preparedStatement.setInt(4,employee.getEmployeePhone());
            preparedStatement.executeUpdate();
            System.out.println("employee added ");
        }catch (SQLException e){
            throw new RuntimeException();

        }
        finally {
            try {
                connection.close();
            }catch (SQLException e){
                throw new RuntimeException();
            }
        }


    }

    public void updateEmployee(Employee employee){
        Connection connection = ConnectionUtil.getConnection();
        String query = "update manager_app.Employees set empName=?,empCity=?,empPhone=? where empId=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,employee.getEmployeeName());
            preparedStatement.setString(2,employee.getEmployeeCity());
            preparedStatement.setInt(3,employee.getEmployeePhone());
            preparedStatement.setInt(4,employee.getEmployeeId());
            preparedStatement.executeUpdate();
            System.out.println("employee updated successsfully");
        }catch (SQLException e){
            throw new RuntimeException();
        }
        finally {
            try {
                connection.close();
            }catch (SQLException e){
                throw new RuntimeException();
            }
        }
    }
    public Employee getEmpById(int EmployeeId){
        Connection connection = ConnectionUtil.getConnection();
        String query="select * from manager_app.Employees where empId=?";
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,EmployeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employee = Employee.builder()
                        .EmployeeId(resultSet.getInt("empId"))
                        .EmployeeName(resultSet.getString("empName"))
                        .EmployeeCity(resultSet.getString("empCity"))
                        .EmployeePhone(resultSet.getInt("empPhone"))
                        .build();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        return employee ;

    }

    public List<Employee> getAllEmployee(){
        Connection connection = ConnectionUtil.getConnection();
        String query = "select * from manager_app.Employees";
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee employee = Employee.builder()
                        .EmployeeId(resultSet.getInt("empId"))
                        .EmployeeName(resultSet.getString("empName"))
                        .EmployeeCity(resultSet.getString("empCity"))
                        .EmployeePhone(resultSet.getInt("empPhone"))
                        .build();
                employeeList.add(employee);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        return employeeList;
    }

    public void deleteEmployee(int EmployeeId){
        Connection connection = ConnectionUtil.getConnection();
        String query = "delete from manager_app.Employees where empId=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,EmployeeId);
            preparedStatement.executeUpdate();
            System.out.println("deleted successfully");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

}
