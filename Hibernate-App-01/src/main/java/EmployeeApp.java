import Controller.EmplyoeeController;
import Dao.EmployeeDao;
import Model.ContractEmployee;
import Model.Employee;
import Model.FulTimeEmployee;

public class EmployeeApp {
    public static void main(String[] args) {
        /*EmplyoeeController emplyoeeController = new EmplyoeeController();
        emplyoeeController.addEmployee(Employee.builder()
                .employeeName("Aniket")
                .build());

         */






       /* FulTimeEmployee fulTimeEmployee = new FulTimeEmployee();
        fulTimeEmployee.setEmployeeName("Ganesh");
        fulTimeEmployee.setSalary(40000);
        emplyoeeController.addEmployee(fulTimeEmployee);

        */
       /* ContractEmployee contractEmployee = new ContractEmployee();
        contractEmployee.setEmployeeName("Nikhil");
        contractEmployee.setInvoiceAmount(25000);
        emplyoeeController.addEmployee(contractEmployee);

        */
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.getEmployee(2);
        System.out.println(employee);









    }


}
