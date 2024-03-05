package org.example.Controller;

import org.example.Model.Employee;
import org.example.Service.EmpService;

import java.util.List;

public class EmpController {
    EmpService empService = new EmpService();
    public void addEmployee(Employee employee){
        empService.addEmployee(employee);
    }

    public void updateEmployee(Employee employee){
        empService.updateEmployee(employee);
    }

    public Employee getEmpById(int EmployeeId){
        return empService.getEmpById(EmployeeId);
    }

    public List<Employee> getAllEmployee(){
        return empService.getAllEmployee();
    }
    public void deleteEmployee(int EmployeeId){
        empService.deleteEmployee(EmployeeId);
    }
}
