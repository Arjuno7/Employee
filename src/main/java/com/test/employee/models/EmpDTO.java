package com.test.employee.models;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmpDTO {
    String name;
    Integer age;
    Integer sal;

    public EmpDTO(String name, Integer age,Integer sal) {
        this.name = name;
        this.age = age;
        this.sal=sal;

    }
}
