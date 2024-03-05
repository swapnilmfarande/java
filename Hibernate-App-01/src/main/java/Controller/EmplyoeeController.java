package Controller;

import Model.Employee;
import Service.EmployeeService;

public class EmplyoeeController {
    EmployeeService employeeService = new EmployeeService();
    public void addEmployee(Employee employee){
        employeeService.addEmployee(employee);
    }
}
