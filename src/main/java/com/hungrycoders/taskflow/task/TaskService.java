package com.hungrycoders.taskflow.task;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;


import com.hungrycoders.taskflow.task.dto.CreateTaskRequest;

@Service
public class TaskService {

	// A thread Safe in Memory store . Replace by real DB in Phase 3

	private final Map<Long, Task> store = new ConcurrentHashMap<>();

	private final AtomicLong sequence = new AtomicLong();

	public List<Task> findAll() {
		return List.copyOf(store.values());
	}

	public Optional<Task> findById(Long id) {
		//return Optional.ofNullable(store.get(id));
		
		 Task task = store.get(id);
		    if (task == null) {
		        throw new TaskNotFoundException(id);
		    }
		    return Optional.ofNullable(store.get(id));
		
		
	}

	public Task create(String title, boolean completed) {
		long id = sequence.incrementAndGet(); // server assigns the id

		Task task = new Task(id ,title, completed);

		store.put(id, task);

		return task;

	}

	/** full replacement Returns Empty if the task doesn't exist. */

	public Optional<Task> replace(Long id, CreateTaskRequest request) {
		if (!store.containsKey(id)) {
			return Optional.empty();
		}

		Task updated = new Task(id, request.title(), request.completed());
		store.put(id, updated);
		return Optional.of(updated);
	}

	/** Returns true if something was actually removed. */

	public boolean delete(Long id) {
		return store.remove(id) != null;

	}

}