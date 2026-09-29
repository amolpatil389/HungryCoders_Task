package com.hungrycoders.taskflow;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TaskflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskflowApplication.class, args);
		
//		SpringApplication app = new SpringApplication(TaskflowApplication.class);
//		app.setBannerMode(Banner.Mode.OFF);
//		app.run(args);
		
//		new SpringApplicationBuilder(TaskflowApplication.class)
//		.bannerMode(Banner.Mode.OFF)
//		.run(args);
		
	}

	@Component
	public class StartupRunner implements CommandLineRunner {
		private static final Logger log = LoggerFactory.getLogger(StartupRunner.class);

		@Override
		public void run(String... args) throws Exception {

			log.info("TaskFlow has started. Received {} command-line argument(s).", args.length);
			log.info("Visit http://localhost:8080/ to see the welcome endpoint.");

		}

	}

}
