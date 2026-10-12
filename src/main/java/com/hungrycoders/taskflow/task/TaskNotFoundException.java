package com.hungrycoders.taskflow.task;

public class TaskNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TaskNotFoundException(Long id)
	{
		super("Task Not found exception = "+id);
	}
	

	
	

}
