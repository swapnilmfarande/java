package org.example.Service;

import org.example.Dao.EmpDao;
import org.example.Model.Employee;

import java.util.List;

public class EmpService {
    EmpDao empDao = new EmpDao();
    public void addEmployee(Employee employee){
        empDao.addEmployee(employee);
    }

    public void updateEmployee(Employee employee){
        empDao.updateEmployee(employee);
    }

    public Employee getEmpById(int EmployeeId){
        return empDao.getEmpById(EmployeeId);
    }
    public List<Employee> getAllEmployee(){
        return empDao.getAllEmployee();
    }

    public void deleteEmployee(int EmployeeId){
        empDao.deleteEmployee(EmployeeId);
    }
}
