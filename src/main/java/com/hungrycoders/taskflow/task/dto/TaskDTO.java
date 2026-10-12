package com.hungrycoders.taskflow.task.dto;

public class TaskDTO {

//	/**
//	 * What a client sends to create a task. Note the validation annotations: these
//	 * rules are checked automatically before our controller logic runs.
//	 */
//
////	public record CreateTaskRequest(
////
////			@NotBlank(message = "Title is required") @Size(max = 120, message = "Title must be at most 120 characters")
////			String title,
////			boolean completed) {
////	}
//
//	public record TaskResponse(Long id, String title, boolean completed, String status) {
//	}
//
//	/** Factory method to map a domain Task into its response representation. */
//	
//	public static TaskResponse from(Task task) {
//		return new TaskResponse(
//				task.id(), task.title(), task.completed(),task.completed() ? "DONE" : "COMPLETED");
//	}
//	
//	public record Task(Long id,String title,boolean completed) {}

}
