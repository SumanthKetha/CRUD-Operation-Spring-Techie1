package com.spring.techie.sumanth;

import com.spring.techie.sumanth.controllers.EmployeeController;
import com.spring.techie.sumanth.impl.EmployeeServiceImpl;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableCaching
public class CrudOperationSpringTechieApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(CrudOperationSpringTechieApplication.class, args);

		EmployeeController bean = run.getBean(EmployeeController.class);
		System.out.println(bean.hashCode());
		EmployeeController bean1 = (EmployeeController)run.getBean("employeeController");
		System.out.println(bean1.hashCode());
		System.out.println(run.containsBean("employeeService"));
		EmployeeServiceImpl employeeService = run.getBean( EmployeeServiceImpl.class);
		System.out.println(employeeService.getClass().getSimpleName());

	}

	@PostConstruct
	public void welcome() {
		System.out.println("Hello Welcome to Application");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Bye!!");
	}

}
