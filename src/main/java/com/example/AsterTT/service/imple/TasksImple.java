package com.example.AsterTT.service.imple;

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

}
