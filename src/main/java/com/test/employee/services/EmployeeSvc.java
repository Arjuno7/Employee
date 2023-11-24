package com.test.employee.services;

import com.test.employee.models.EmpDTO;
import com.test.employee.models.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeSvc {

    @Autowired
    final  EmploeeRepo emploeeRepo;

    public List<Employee> getAllEmployees() {
        return this.emploeeRepo.findAll();
    }

    public void addEmployee(EmpDTO emp) {
        Employee employee = new Employee(emp.getName(),emp.getAge(),emp.getSal());
        emploeeRepo.save(employee);

    }


//    public EmpDTO findByName(String name) {
//        Employee e =  emploeeRepo.findByName(name);
//        EmpDTO empDTO = new EmpDTO(e.getName(),e.getAge(),e.getSal());
//        return empDTO;
//    }
    public EmpDTO findById(int id) {
        Employee e = emploeeRepo.findById(id) ;
        EmpDTO empDTO = new EmpDTO(e.getName(),e.getAge(),e.getSal());
        return empDTO;
    }

    public Employee updateData(int id,Employee emp){
        Employee emp1=emploeeRepo.findById(id);
        emp1.setName(emp.getName());
        emp1.setAge(emp.getAge());
        emp1.setSal(emp.getSal());
        emploeeRepo.save(emp1);
        return emp1;
    }

    public Employee deleteData(int id){
        Employee e = emploeeRepo.findById(id);
                emploeeRepo.delete(e) ;
        return e;
    }


}
