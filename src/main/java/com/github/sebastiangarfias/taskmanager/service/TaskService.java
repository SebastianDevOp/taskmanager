package com.github.sebastiangarfias.taskmanager.service;

import com.github.sebastiangarfias.taskmanager.model.Category;
import com.github.sebastiangarfias.taskmanager.model.Status;
import com.github.sebastiangarfias.taskmanager.model.Task;
import com.github.sebastiangarfias.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Task createTask( String title,
                            String description,
                            Category category){
        if(title ==null || title.trim().isEmpty()) throw new IllegalArgumentException("title must not be blank");
        if(category == null) throw new IllegalArgumentException("category must be not null");
        return  taskRepository.save(new Task(title,category,description));

    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task updateStatus(   Long id,
                                Status newStatus){
        if(id==null)throw new IllegalArgumentException("id must not be null");
        if(newStatus==null) throw  new IllegalArgumentException(("new status must not be null"));

       Task task = getById(id);

       task.changeStatus(newStatus);

       return taskRepository.save(task);
    }

    public Task getById(Long id){
        if(id==null) throw  new IllegalArgumentException("id must not be null");
        return taskRepository
                .findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }



    public void deleteTask(Long id){
        if(id==null) throw new IllegalArgumentException("id must not be null");
        Task task = getById(id);
        taskRepository.delete(task);
    }

}
