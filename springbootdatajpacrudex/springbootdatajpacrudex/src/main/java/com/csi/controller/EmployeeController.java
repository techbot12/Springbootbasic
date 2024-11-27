package com.csi.controller;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import com.csi.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        log.info("############Trying to save Data For Employee: " + employee.getEmpName());

        return ResponseEntity.ok(employeeService.save(employee));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll() {

        log.info("##########Size Of Employee List: " + employeeService.findAll().size());

        return ResponseEntity.ok(employeeService.findAll());
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> update(@PathVariable int empId, @RequestBody Employee employee) {

        //Exception Code Goes Here
        return ResponseEntity.ok(employeeService.update(employee));
    }


    @DeleteMapping("/deletebyid/{empId}")
    public ResponseEntity<String> deleteById(@PathVariable int empId) {
        employeeService.deleteById(empId);

        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @PostMapping("/savebulkofdata")
    public ResponseEntity<List<Employee>> saveAll(@RequestBody List<Employee> employeeList){

        return ResponseEntity.ok(employeeService.saveAll(employeeList));
    }
}
