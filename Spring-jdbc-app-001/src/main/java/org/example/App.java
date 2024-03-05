package org.example;

import org.example.Controller.EmpController;
import org.example.Model.Employee;
import org.example.Util.SpringJdbcConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App{
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
        EmpController empController =applicationContext.getBean(EmpController.class);
        /*empController.addEmployee(Employee.builder()
                .EmployeeId(107)
                .EmployeeName("Aniket")
                .EmployeeCity("Barshi")
                .EmpPhone(414407)
                .build());

         */
        empController.updateEmployee(Employee.builder()
                .EmployeeId(107)
                .EmployeeName("Rohan")
                .EmployeeCity("Phaltan")
                .EmpPhone(423120)
                .build());


        //empController.deleteEmployee(104);
        //System.out.println(empController.getEmpById(103));
        //empController.getAllEmployee().forEach(System.out::println);
    }
}

