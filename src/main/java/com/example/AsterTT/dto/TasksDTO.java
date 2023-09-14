package com.example.AsterTT.dto;


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

}
