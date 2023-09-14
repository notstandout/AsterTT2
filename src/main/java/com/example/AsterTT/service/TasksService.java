package com.example.AsterTT.service;

import com.example.AsterTT.dto.TasksDTO;
import com.example.AsterTT.entity.Tasks;

import java.util.List;

public interface TasksService {
    public Tasks getOneById(int id);
    public List<Tasks> getAll();
    public List<Tasks> getAllByDoneIsTrue();
    public List<Tasks> getAllByDoneIsFalse();
    public TasksDTO createTask(Tasks tasks);
    public TasksDTO createNewTask(TasksDTO tasksDTO);

    public TasksDTO getOne(Tasks tasks);
    public TasksDTO update(TasksDTO tasksDTO);

    public void deleteTask(int id);


}
