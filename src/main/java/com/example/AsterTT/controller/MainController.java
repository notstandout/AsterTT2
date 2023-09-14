package com.example.AsterTT.controller;


import org.springframework.ui.Model;
import com.example.AsterTT.dto.TasksDTO;
import com.example.AsterTT.entity.Tasks;
import com.example.AsterTT.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private TasksService tasksService;


    @GetMapping("/getAll")
//    private ResponseEntity<List<Object>> getAll(){
    private String getAll(Model model){
        List<Object> tasksDTOS = tasksService.getAll().stream()
                .map(task -> new TasksDTO(task.getId(), task.getTitle(), task.getDescription(),task.isDone()))
                .collect(Collectors.toList());
        model.addAttribute("allTasks", tasksDTOS);
//        return new ResponseEntity<>(tasksDTOS, HttpStatus.OK);
        return "task/all";
    }
    @GetMapping("/getAllDoneTrue")
//    private ResponseEntity<List<Object>> getAllDoneTrue(){
    private String getAllDoneTrue(Model model){
        List<Object> tasksDTOS = tasksService.getAllByDoneIsTrue().stream()
                .map(task -> new TasksDTO(task.getId(), task.getTitle(), task.getDescription(),task.isDone()))
                .collect(Collectors.toList());
        model.addAttribute("isDoneTasks", tasksDTOS);
//        return new ResponseEntity<>(tasksDTOS, HttpStatus.OK);
        return "task/listIsDone";
    }
    @GetMapping("/getAllDoneFalse")
//    private ResponseEntity<List<Object>> getAllDoneFalse(){
    private String getAllDoneFalse(Model model){
        List<Object> tasksDTOS = tasksService.getAllByDoneIsFalse().stream()
                .map(task -> new TasksDTO(task.getId(), task.getTitle(), task.getDescription(),task.isDone()))
                .collect(Collectors.toList());
        model.addAttribute("isNotDoneTasks", tasksDTOS);
//        return new ResponseEntity<>(tasksDTOS, HttpStatus.OK);
        return "task/listIsNotDone";
    }
    @GetMapping("/getOne/{taskId}")
//    private ResponseEntity<Object> getOne(@PathVariable(name = "taskId")Integer id){
    private String getOne(@PathVariable(name = "taskId")Integer id, Model model){
        Tasks tasks = tasksService.getOneById(id);
        model.addAttribute("task", tasks);
        return "task/dataTask";
//        if (tasks!=null){
//            return new ResponseEntity<>(tasksService.getOne(tasks), HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>("status: \"NOT_FOUND\"", HttpStatus.NOT_FOUND);
//        }
    }


    @PostMapping("/post")
    private ResponseEntity<Object> createTask(@RequestBody TasksDTO tasksDTO){
        Tasks tasks = tasksService.getOneById(tasksDTO.getId());
        if (tasks!=null){
            return new ResponseEntity<>(tasksService.createTask(tasks),HttpStatus.RESET_CONTENT);
        }else{
            return new ResponseEntity<>(tasksService.createNewTask(tasksDTO),HttpStatus.CREATED);
        }
    }


    @PutMapping("/update/{taskId}")
    private ResponseEntity<Object> updateTask(@PathVariable(name = "taskId")Integer id, TasksDTO tasksDTO) {
        TasksDTO tasks = tasksService.update(tasksDTO);
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/delete/{taskId}")
    private ResponseEntity<Void> deleteTask(@PathVariable(name = "taskId")Integer id){
        tasksService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }



}
