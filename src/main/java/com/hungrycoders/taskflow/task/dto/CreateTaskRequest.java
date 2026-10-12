package com.hungrycoders.taskflow.task.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


	
	/**
	 * What a client sends to create a task. Note the validation annotations: these
	 * rules are checked automatically before our controller logic runs.
	 */

	public record CreateTaskRequest(

			@NotBlank(message = "Title is required") @Size(max = 120, message = "Title must be at most 120 characters")
			String title,
			boolean completed) {}


