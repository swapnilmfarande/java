package org.example;

import org.example.Controller.EmpController;
import org.example.Model.Employee;

/**
 * Hello world!
 *
 */
public class App{
    public static void main(String[] args) {
        EmpController empController = new EmpController();
        /*empController.addEmployee(Employee.builder()
                .EmployeeId(101)
                .EmployeeName("Rahul")
                .EmployeeCity("Baramati")
                .EmployeePhone(443321)
                .build());

         */
       /* empController.updateEmployee(Employee.builder()
                .EmployeeId(103)
                .EmployeeName("Akshay")
                .EmployeeCity("Aasti")
                .EmployeePhone(443321)
                .build());

        */
       // System.out.println(empController.getEmpById(103));
        //empController.getAllEmployee().forEach(System.out::println);
        empController.deleteEmployee(104);
    }
}

