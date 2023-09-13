package com.example.AsterTT.service;

import com.example.AsterTT.entity.Tasks;

import java.util.List;

public interface TasksService {
    public Tasks getOneById(int id);
    public List<Tasks> getAll();
    public List<Tasks> getAllByDoneIsTrue();
    public List<Tasks> getAllByDoneIsFalse();


}
