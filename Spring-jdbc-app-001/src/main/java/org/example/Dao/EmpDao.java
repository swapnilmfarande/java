package org.example.Dao;

import lombok.AllArgsConstructor;
import org.example.Model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class EmpDao {
      JdbcTemplate jdbcTemplate;

    public void addEmployee(Employee employee){
        String query = "insert into manager_app.Employees(empId,empName,empCity,empPhone)values(?,?,?,?)";
        jdbcTemplate.update(query,preparedStatement -> {
            preparedStatement.setInt(1,employee.getEmployeeId());
            preparedStatement.setString(2,employee.getEmployeeName());
            preparedStatement.setString(3,employee.getEmployeeCity());
            preparedStatement.setInt(4,employee.getEmpPhone());
        });
        System.out.println("Employee Added");

    }

    public void updateEmployee(Employee employee){
        String query = "update manager_app.Employees set empName=?,empCity=?,empPhone=? where empId=?";
        jdbcTemplate.update(query,preparedStatement -> {

            preparedStatement.setString(1,employee.getEmployeeName());
            preparedStatement.setString(2,employee.getEmployeeCity());
            preparedStatement.setInt(3,employee.getEmpPhone());
            preparedStatement.setInt(4,employee.getEmployeeId());
        });
        System.out.println("Employee Updated");


    }

    public void deleteEmployee(int EmployeeId){
        String query = "delete from manager_app.Employees where empId=?";
        jdbcTemplate.update(query,preparedStatement ->{
            preparedStatement.setInt(1,EmployeeId);
        });
        System.out.println("Employee deleted");


    }

    public List<Employee> getAllEmployee(){
        String query1 = "select * from manager_app.Employees";
        ResultSetExtractor<List<Employee>> resultSetExtractor = (rs -> {
            List<Employee> employeeList = new ArrayList<>();

            while (rs.next()){
                Employee employee = Employee.builder()
                        .EmployeeId(rs.getInt("empId"))
                        .EmployeeName(rs.getString("empName"))
                        .EmployeeCity(rs.getString("empCity"))
                        .EmpPhone(rs.getInt("empPhone"))
                        .build();
                employeeList.add(employee);
            }
            return employeeList;

        });
        return jdbcTemplate.query(query1,resultSetExtractor);


    }

    public Employee getEmpById(int EmployeeId){
        String query2 = "select * from manager_app.Employees where empId="+EmployeeId;
        RowMapper<Employee> rowMapper = (((rs, rowNum) -> Employee.builder()
                .EmployeeId(rs.getInt("empId"))
                .EmployeeName(rs.getString("empName"))
                .EmployeeCity(rs.getString("empCity"))
                .EmpPhone(rs.getInt("empPhone"))
                .build()));
        return jdbcTemplate .queryForObject(query2,rowMapper);
    }
    







}
