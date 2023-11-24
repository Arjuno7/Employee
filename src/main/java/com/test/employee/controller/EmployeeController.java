package com.test.employee.controller;

import com.test.employee.models.EmpDTO;
import com.test.employee.models.Employee;
import com.test.employee.services.EmployeeSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    EmployeeSvc employeeSvc;

    @GetMapping("/getAll")
    List<Employee> get() {
        return employeeSvc.getAllEmployees();
    }

    @PostMapping("/addEmp")
    public String saveData(@RequestBody EmpDTO empDTO){
        employeeSvc.addEmployee(empDTO);
        return "Employee Added Succesfully";
    }
    @GetMapping("/getbyId/{id}")
    public EmpDTO listbyId(@PathVariable int id) {
        return employeeSvc.findById(id);
    }

    @PutMapping("/editEmp/{id}")
    String update(@PathVariable int id,@RequestBody Employee e){
        employeeSvc.updateData(id,e);
        return "Details Edited Succesfully";
    }

    @DeleteMapping("/delEmp/{id}")
    String DeleteEmp(@PathVariable int id){
        employeeSvc.deleteData(id);
        return "Employee Deleted Succesfully";
    }

//    @GetMapping("{id}")
//    List<Employee> get(@PathVariable String id){
//        return employeeSvc.;
//    }
}
