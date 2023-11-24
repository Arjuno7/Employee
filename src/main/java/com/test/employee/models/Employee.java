package com.test.employee.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.UUID;
@Component
@Getter
@Setter
@Entity
@Table(name="employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int age;
    int sal;

    public Employee(String name, int age,int sal) {
        this.name = name;
        this.age = age;
        this.sal= sal;
        //this.id = UUID.randomUUID().toString();
    }
}
