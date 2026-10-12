package com.hungrycoders.taskflow.task.dto;

import com.hungrycoders.taskflow.task.Task;

public record TaskResponse(Long id, String title, boolean completed, String status) {
	
	/** Factory method to map a domain Task into its response representation. */	

	public static TaskResponse from(Task task) {
		return new TaskResponse(task.id(), task.title(), task.completed(), task.completed() ? "DONE" : "IN-PROGRESS");
	}

	

}
