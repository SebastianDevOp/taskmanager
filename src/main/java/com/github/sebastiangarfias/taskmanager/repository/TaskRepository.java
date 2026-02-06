package com.github.sebastiangarfias.taskmanager.repository;

import com.github.sebastiangarfias.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}