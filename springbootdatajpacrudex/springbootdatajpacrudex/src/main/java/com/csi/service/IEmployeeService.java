package com.csi.service;

import com.csi.model.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee save(Employee employee);

    List<Employee> findAll();

    Employee update(Employee employee);

    void deleteById(int empId);

    List<Employee> saveAll(List<Employee> employeeList);


}
