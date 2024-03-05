package Service;

import Dao.EmployeeDao;
import Model.Employee;

public class EmployeeService {
    EmployeeDao employeeDao = new EmployeeDao();
    public void addEmployee(Employee employee){

        employeeDao.addEmployee(employee);
    }
}
