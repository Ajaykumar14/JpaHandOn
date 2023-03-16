package com.data.handOnJpa;

import com.data.handOnJpa.entity.Employee;
import com.data.handOnJpa.repository.EmployeeRepository;
import com.data.handOnJpa.service.EmployeeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class HandOnJpaApplication {

	public static void main(String[] args) throws IOException {

		ConfigurableApplicationContext context= SpringApplication.run(HandOnJpaApplication.class, args);
		EmployeeRepository employeeRepository =context.getBean(EmployeeRepository.class);
		/*Employee emp = new Employee();
		emp.setEmail("test@test.com");
		emp.setFirst_name("hello");
		emp.setLast_name("World");
		emp.setGender("Male");
		emp.setSalary("1000000");
		employeeRepository.save(emp);*/

		EmployeeServiceImpl employeeService = context.getBean(EmployeeServiceImpl.class);
		employeeService.getEmployeeData().forEach(System.out::println);

		employeeRepository.saveAll(employeeService.getEmployeeData());
	}

}
