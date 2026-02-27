package com.github.sebastiangarfias.taskmanager.controller;

import com.github.sebastiangarfias.taskmanager.controller.dto.CreateTaskRequest;
import com.github.sebastiangarfias.taskmanager.service.TaskService;
import com.github.sebastiangarfias.taskmanager.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> allTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody CreateTaskRequest request){
        return taskService.createTask(
                request.getTitle(),
                request.getDescription(),
                request.getCategory()
        );
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getById(id);
    }

}
