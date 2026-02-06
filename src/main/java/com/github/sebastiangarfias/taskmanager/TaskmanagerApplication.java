package com.github.sebastiangarfias.taskmanager;

import com.github.sebastiangarfias.taskmanager.model.Task;
import com.github.sebastiangarfias.taskmanager.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskmanagerApplication  implements CommandLineRunner {

	private final TaskRepository taskRepository;

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}


	Task t1 = new Task();
	@Override
	public void run(String... args) throws Exception {

	}
}
