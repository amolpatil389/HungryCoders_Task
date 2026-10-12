package com.hungrycoders.taskflow;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	public record WelcomeResponse(String application,String status,String message) {}
	
	@GetMapping("/")
	public WelcomeResponse welcome()
	{
		
		return new WelcomeResponse(
				"Taskflow",
				"running",
				"Welcome! Your Spring Boot foundation is ready.");
		//return "Welcome to TaskFlow! Your Spring Boot app is running.";
	}
	
	//public record Task(Long id,String title,boolean completed) {}
	
	//public record TaskRequest(String title, boolean completed) {}
	
	
	
	

}
