package com.test.employee.services;

import com.test.employee.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface EmploeeRepo extends JpaRepository<Employee, Integer> {
//    Employee findByName(String name);
    Employee findById(int id);

//    @Query()
//    Employee findall();

//    Employee updateData(int id);
   // Employee deleteData(int id);
}
