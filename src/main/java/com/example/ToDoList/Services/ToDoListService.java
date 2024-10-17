package com.example.ToDoList.Services;

import com.example.ToDoList.Models.ToDoList;
import com.example.ToDoList.Repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService {
    private final ToDoListRepository toDoListRepository;

    @Autowired
    public ToDoListService(ToDoListRepository toDoListRepository){
        this.toDoListRepository = toDoListRepository;
    }

    public List<ToDoList> findAll(){
        return this.toDoListRepository.findAll();
    }

    public Optional<ToDoList> findById(@PathVariable Long id){
        return this.toDoListRepository.findById(id);
    }

    public void createList(@RequestBody ToDoList toDoList){
        this.toDoListRepository.save(toDoList);
    }

    public void updateById(Long id, ToDoList toDoList){
        this.toDoListRepository.updateToDoListById(id, toDoList.getTitle());
    }

    public void deleteById(Long id){
        this.toDoListRepository.deleteById(id);
    }

}
