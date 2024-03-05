package org.example.Service;

import lombok.AllArgsConstructor;
import org.example.Dao.EmpDao;
import org.example.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmpService {
    EmpDao empDao;

    public void addEmployee(Employee employee){
        empDao.addEmployee(employee);
    }
    public void updateEmployee(Employee employee){
        empDao.updateEmployee(employee);
    }

    public void deleteEmployee(int EmployeeId){
        empDao.deleteEmployee(EmployeeId);
    }
    public List<Employee> getAllEmployee(){
        return empDao.getAllEmployee();
    }

    public Employee getEmpById(int EmployeeId){
        return empDao.getEmpById(EmployeeId);
    }


}
