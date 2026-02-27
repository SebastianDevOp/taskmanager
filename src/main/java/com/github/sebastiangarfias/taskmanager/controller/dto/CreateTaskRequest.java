package com.github.sebastiangarfias.taskmanager.controller.dto;

import com.github.sebastiangarfias.taskmanager.model.Category;
import com.github.sebastiangarfias.taskmanager.model.Task;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CreateTaskRequest{

    private String title;
    private String description;
    private Category category;

    public CreateTaskRequest(){}

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public Category getCategory(){
        return this.category;
    }

}