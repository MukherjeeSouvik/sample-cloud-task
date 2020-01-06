package com.souvik.task;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableTask
@SpringBootApplication
public class CloudTaskAppApplication {
	
	@Autowired
	private InstanceInformationService informationService;

	public static void main(String[] args) {
		SpringApplication.run(CloudTaskAppApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner applicationRunner() {
		return new ApplicationRunner() {
			
			@Override
			public void run(ApplicationArguments args) throws Exception {
				log.info("Application Executed at : {}, host : {}", Calendar.getInstance(), informationService.getHostName());
				
			}
		};
		
	}
	
	@Bean
	public TaskExecutionListener listener() {
		return new TaskListener();
	}

}
