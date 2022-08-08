package com.zaurtregulov.spring.springboot.springboot_rest.dao;

import com.zaurtregulov.spring.springboot.springboot_rest.entity.Employee;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        // при использовании hibernate
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> employees = query.getResultList();
//        return employees;


        // при использовании jpa
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee getEmployee(int id) {
        // при использовании hibernate
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);
//        return employee;

        // при использовании jpa
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void saveEmp(Employee employee) {
        // при использовании hibernate
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);

        // при использовании jpa
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }


    @Override
    public void deleteEmp(int id) {
        // при использовании hibernate
//        Session session1 = entityManager.unwrap(Session.class);
//        Query<Employee> query = session1.createQuery("delete from Employee " +
//                "where id =:employeeID");
//        query.setParameter("employeeID", id);
//        query.executeUpdate();

        // при использовании jpa
        Query query = entityManager.createQuery("delete from Employee where id =:employeeID");
        query.setParameter("employeeID", id);
        query.executeUpdate();
    }
}
