package com.example.ToDoList.Controllers;

import com.example.ToDoList.Models.ToDoList;
import com.example.ToDoList.Repository.ToDoListRepository;
import com.example.ToDoList.Services.ToDoListService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todolist")
public class ToDoListController {

    private final ToDoListService toDoListService;
    private final static Logger log = LoggerFactory.getLogger(ToDoListController.class);

    @Autowired
    public ToDoListController(ToDoListService toDoListService){
        this.toDoListService = toDoListService;
    }

    @GetMapping("/{id}")
    Optional<ToDoList> findAById(@PathVariable Long id){
        return this.toDoListService.findById(id);
    }

    @GetMapping("")
    List<ToDoList> findAll(){
        return this.toDoListService.findAll();
    }

    @PostMapping("")
    @Transactional
    void save(@RequestBody ToDoList toDoList){
        this.toDoListService.createList(toDoList);
    }

    @PutMapping("/{id}")
    @Transactional
    void updateById(@PathVariable Long id, @RequestBody ToDoList toDoList){
        this.toDoListService.updateById(id,toDoList) ;
    }

    @DeleteMapping("/{id}")
    @Transactional
    void deleteAById(@PathVariable Long id){
        this.toDoListService.deleteById(id);
    }
}
