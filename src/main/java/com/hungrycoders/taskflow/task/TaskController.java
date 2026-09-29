package com.hungrycoders.taskflow.task;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hungrycoders.taskflow.WelcomeController.Task;
import com.hungrycoders.taskflow.WelcomeController.TaskRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	/** GET /tasks — return the whole collection. */
	@GetMapping
	public List<Task> list() {
		return taskService.finAll();
	}

	/** GET /tasks/{id} — return one task, or 404 if it doesn't exist. */
	@GetMapping("/{id}")
	public ResponseEntity<Task> getOne(@PathVariable Long id) {
		return taskService.findById(id).map(ResponseEntity::ok) // 200 with the Task
				.orElse(ResponseEntity.notFound().build()); // 404 if absent
	}

	/** POST /tasks — create a task, return 201 with a Location header. */
	@PostMapping
	public ResponseEntity<Task> create(@RequestBody TaskRequest request) {
		Task created = taskService.create(request);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(created.id())
				.toUri();

		return ResponseEntity.created(location).body(created);
	}

	/** PUT /tasks/{id} — replace a task entirely, or 404 if it doesn't exist. */
	@PutMapping("/{id}")
	public ResponseEntity<Task> replace(@PathVariable Long id, @RequestBody TaskRequest request)
	{
		return taskService.replace(id, request)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	/** DELETE /tasks/{id} — remove a task, return 204, or 404 if absent. */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id)
	{
		return taskService.delete(id) 
				? ResponseEntity.noContent().build()             // 204 No Content
	            : ResponseEntity.notFound().build();  			// 404
	}

}
