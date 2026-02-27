package com.github.sebastiangarfias.taskmanager.service;

import com.github.sebastiangarfias.taskmanager.model.Category;
import com.github.sebastiangarfias.taskmanager.model.Status;
import com.github.sebastiangarfias.taskmanager.model.Task;
import com.github.sebastiangarfias.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.context.TestConstructor.AutowireMode.ALL;

@SpringBootTest
@TestConstructor(autowireMode = ALL)
class TaskServiceTest {

    private final TaskService taskService;
    private final TaskRepository taskRepository;

    TaskServiceTest(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @BeforeEach
    void cleanRepository() {
        taskRepository.deleteAll();
    }

    @Test
    void createTask_validInput_persistsTask() {
        Task created = taskService.createTask("Learn Spring Boot", "service test", Category.WORK);

        assertNotNull(created, "created task should not be null");
        assertNotNull(created.getId(), "id should be generated");
        assertEquals(1L, taskRepository.count(), "one task should be saved");
    }

    @Test
    void createTask_blankTitle_throwsAndDoesNotPersist() {
        assertThrows(IllegalArgumentException.class,
                () -> taskService.createTask(" ", "...", Category.WORK));

        assertEquals(0L, taskRepository.count(), "no task should be saved");
    }

    @Test
    void createTask_nullCategory_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> taskService.createTask("Learn Spring Boot", "service test", null));
    }

    @Test
    void updateStatus_whenTaskAlreadyDone_throws() {
        Task task = taskService.createTask("Learn Spring Boot", "service test", Category.WORK);

        taskService.updateStatus(task.getId(), Status.DONE);

        assertThrows(IllegalArgumentException.class,
                () -> taskService.updateStatus(task.getId(), Status.IN_WORK),
                "DONE should be final");
    }

    @Test
    void deleteTask_existingTask_deletesTask() {
        Task task = taskService.createTask("Learn Spring Boot", "service test", Category.WORK);

        taskService.deleteTask(task.getId());

        assertEquals(0L, taskRepository.count());
        assertFalse(taskRepository.existsById(task.getId()), "task should be deleted");
    }
}
