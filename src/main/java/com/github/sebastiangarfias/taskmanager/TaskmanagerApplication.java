package com.github.sebastiangarfias.taskmanager;

import com.github.sebastiangarfias.taskmanager.model.Category;
import com.github.sebastiangarfias.taskmanager.model.Status;
import com.github.sebastiangarfias.taskmanager.model.Task;
import com.github.sebastiangarfias.taskmanager.repository.TaskRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskmanagerApplication {

	public static void main(String[] args){
		SpringApplication.run(TaskmanagerApplication.class, args);
	}

}
