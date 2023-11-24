package com.test.employee;

import com.test.employee.models.EmpDTO;
import com.test.employee.models.Employee;
import com.test.employee.services.EmploeeRepo;
import com.test.employee.services.EmployeeSvc;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class EmployeeApplicationTests {

	@MockBean
	private EmploeeRepo emploeeRepo;
//	private EmpDTO empl;
//	private Employee emp,emmp;
	@Autowired
	private EmployeeSvc employeeSvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllEmployees(){
		when(emploeeRepo.findAll()).thenReturn(Stream.of(new Employee(36,"Shuvam",25,2000),new Employee(25,"Ranvir",63,5000)).collect(Collectors.toList()));
		assertEquals(2,employeeSvc.getAllEmployees().size() );
	}


}
