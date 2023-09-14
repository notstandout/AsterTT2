package com.example.AsterTT.dto;


import com.example.AsterTT.entity.Tasks;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TasksDTO {

    private int id;

    private String title;

    private String description;

    private boolean done;

    public TasksDTO(Tasks task){
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.done = task.isDone();
    }
}
