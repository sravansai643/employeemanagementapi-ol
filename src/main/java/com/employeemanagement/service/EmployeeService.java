package com.employeemanagement.service;
import java.util.List;
import com.employeemanagement.entity.Employee;
import com.employeemanagement.repository.EmployeeRepository;
import com.employeemanagement.util.EmployeeCalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        // EmployeeCalUtil.calculateHraDA(employee);
        employee.setHra(EmployeeCalUtil.calculateHra(employee.getSal()));
        employee.setDa(EmployeeCalUtil.calculateDa(employee.getSal()));
        employee.setTax(EmployeeCalUtil.calculateTax(employee.getSal()));
        employee.setGross(employee.getSal() + employee.getHra() + employee.getDa() - employee.getTax());
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Integer id) {
        return employeeRepository.findById(id).get();
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Employee employee) {
        Employee updateEmployee = employeeRepository.findById(employee.getEno()).get();
        updateEmployee.setName(employee.getName());
        updateEmployee.setGender(employee.getGender());
        updateEmployee.setSal(employee.getSal());
        updateEmployee.setHra(EmployeeCalUtil.calculateHra(employee.getSal()));
        updateEmployee.setDa(EmployeeCalUtil.calculateDa(employee.getSal()));
        updateEmployee.setTax(EmployeeCalUtil.calculateTax(employee.getSal()));
        updateEmployee.setGross(
                employee.getSal() + updateEmployee.getHra() + updateEmployee.getDa() - updateEmployee.getTax());
        employeeRepository.save(updateEmployee);
    }

}
