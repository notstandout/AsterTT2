package com.example.AsterTT.service.imple;

import com.example.AsterTT.dto.TasksDTO;
import com.example.AsterTT.entity.Tasks;
import com.example.AsterTT.repository.TasksRepo;
import com.example.AsterTT.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TasksImple implements TasksService {

    @Autowired
    private TasksRepo tasksRepo;

    @Override
    public Tasks getOneById(int id) {
        return tasksRepo.findById(id);
    }

    @Override
    public List<Tasks> getAll() {
        return tasksRepo.findAll();
    }

    @Override
    public List<Tasks> getAllByDoneIsTrue() {
        return tasksRepo.findAllByDoneIsTrueOrderById();
    }
    @Override
    public List<Tasks> getAllByDoneIsFalse() {
        return tasksRepo.findAllByDoneIsFalseOrderById();
    }



    @Override
    public TasksDTO getOne(Tasks tasks) {
        return new TasksDTO(tasks.getId(),tasks.getTitle(),tasks.getDescription(),tasks.isDone());
    }

    @Override
    public TasksDTO createTask(Tasks tasks) {
        return new TasksDTO(tasksRepo.save(tasks));
    }

    @Override
    public TasksDTO createNewTask(TasksDTO tasksDTO) {
        Tasks tasks = new Tasks();
        tasks.setTitle(tasksDTO.getTitle());
        tasks.setDescription(tasks.getDescription());
        tasks.setDone(tasksDTO.isDone());
        tasksRepo.save(tasks);
        TasksDTO dto = new TasksDTO(tasks);
        return dto;
    }

    @Override
    public TasksDTO update(TasksDTO tasksDTO) {
        tasksRepo.update(tasksDTO.getId());
        Tasks task = getOneById(tasksDTO.getId());
        TasksDTO tasks = new TasksDTO(task);
        return tasks;
    }

    @Override
    public void deleteTask(int id) {
        tasksRepo.deleteById(id);
    }
}
