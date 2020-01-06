package com.souvik.task;

import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TaskListener implements TaskExecutionListener {

	@Override
	public void onTaskStartup(TaskExecution taskExecution) {
		log.info("Sample Cloud Task - STARTED...!");
		
	}

	@Override
	public void onTaskEnd(TaskExecution taskExecution) {
		log.info("Sample Cloud Task - COMPLETED...!");
	        if (taskExecution.getExitMessage() == null){
	            taskExecution.setExitMessage("Success!");
	        }
		
	}

	@Override
	public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
		log.info("Sample Cloud Task - FAILED...!");
		log.info("Sample Cloud Task Failed due to: {} because {}", throwable.getMessage(), throwable.getCause().getMessage());
        taskExecution.setExitMessage("Failed!");
        taskExecution.setErrorMessage(throwable.getMessage());
		
	}

}
