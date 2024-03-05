package org.example.Controller;

import lombok.AllArgsConstructor;
import org.example.Model.Employee;
import org.example.Service.EmpService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class EmpController {
    EmpService empService;

    public void addEmployee(Employee employee){
        empService.addEmployee(employee);
    }
    public void updateEmployee(Employee employee){
        empService.updateEmployee(employee);
    }
    public void deleteEmployee(int EmployeeId){
        empService.deleteEmployee(EmployeeId);
    }
    public List<Employee> getAllEmployee(){
        return empService.getAllEmployee();
    }

    public Employee getEmpById(int EmployeeId){
        return empService.getEmpById(EmployeeId);
    }



}
