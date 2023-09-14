package com.example.AsterTT.controller;


import com.example.AsterTT.dto.TasksDTO;
import com.example.AsterTT.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private TasksService tasksService;


    @GetMapping("/getAll")
    private ResponseEntity<List<Object>> getAll(){
        List<Object> tasksDTOS = tasksService.getAll().stream()
                .map(task -> new TasksDTO(task.getId(), task.getTitle(), task.getDescription(),task.isDone()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(tasksDTOS, HttpStatus.OK);
    }
    @GetMapping("/getAllDoneTrue")
    private ResponseEntity<List<Object>> getAllDoneTrue(){
        List<Object> tasksDTOS = tasksService.getAllByDoneIsTrue().stream()
                .map(task -> new TasksDTO(task.getId(), task.getTitle(), task.getDescription(),task.isDone()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(tasksDTOS, HttpStatus.OK);
    }
    @GetMapping("/getAllDoneFalse")
    private ResponseEntity<List<Object>> getAllDoneFalse(){
        List<Object> tasksDTOS = tasksService.getAllByDoneIsFalse().stream()
                .map(task -> new TasksDTO(task.getId(), task.getTitle(), task.getDescription(),task.isDone()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(tasksDTOS, HttpStatus.OK);
    }
}
