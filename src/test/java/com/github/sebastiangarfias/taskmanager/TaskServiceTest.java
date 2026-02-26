package com.github.sebastiangarfias.taskmanager;

import com.github.sebastiangarfias.taskmanager.model.Category;
import com.github.sebastiangarfias.taskmanager.model.Task;
import com.github.sebastiangarfias.taskmanager.repository.TaskRepository;
import com.github.sebastiangarfias.taskmanager.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TaskServiceTest {

    private final TaskService taskService;
    private final TaskRepository taskRepository;

    TaskServiceTest(TaskService taskService,
                    TaskRepository taskRepository){
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @Test
    void createTask() {
        Task created = taskService.createTask("Learn Spring Boot","service Test", Category.WORK);
        assertNotNull(created, "task should be generated");
        assertNotNull(created.getId(),"id should be generated");
    }

}
