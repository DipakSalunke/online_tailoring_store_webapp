package com.Tailoring.store.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.Tailoring.store.management.Config.DBConfig;




@SpringBootApplication(scanBasePackages={"com.Tailoring.store.management.Config","com.Tailoring.store.management.Controller","com.Tailoring.store.management.Model","com.Tailoring.store.management.Service"})
//@ComponentScan(basePackages={"com.Tailoring.store.management.Controller","com.Tailoring.store.management.Model","com.Tailoring.store.management.Service","com.Tailoring.store.management.Config"})
public class OnlineTailoringStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlineTailoringStoreApplication.class, args);
		System.out.println("working");
		AnnotationConfigApplicationContext applicationContextDatabase = new AnnotationConfigApplicationContext(DBConfig.class);
		
	}
}
