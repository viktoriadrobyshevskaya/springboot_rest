package com.zaurtregulov.spring.springboot.springboot_rest.service;


import com.zaurtregulov.spring.springboot.springboot_rest.dao.EmployeeDAO;
import com.zaurtregulov.spring.springboot.springboot_rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmp(Employee employee) {
        employeeDAO.saveEmp(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmp(int id) {
        employeeDAO.deleteEmp(id);
    }
}
