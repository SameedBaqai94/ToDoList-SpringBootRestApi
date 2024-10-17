package com.example.ToDoList.Controllers;


import com.example.ToDoList.Models.Items;
import com.example.ToDoList.Models.ToDoList;
import com.example.ToDoList.Repository.ItemsRepository;
import com.example.ToDoList.Repository.ToDoListRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemsController {

    private final ItemsRepository itemsRepository;
    private final ToDoListRepository toDoListRepository;

    @Autowired
    public ItemsController(ItemsRepository itemsRepository,ToDoListRepository toDoListRepository) {
        this.itemsRepository = itemsRepository;
        this.toDoListRepository = toDoListRepository;
    }

    @GetMapping("")
    List<Items> getAllItems() {
        return itemsRepository.findAll();
    }

    @Transactional
    @PostMapping("{listId}")
    void addItem(@PathVariable Long listId, @RequestBody Items item) {
        ToDoList toDoList = toDoListRepository.findById(listId).orElseThrow();
        item.setToDoList(toDoList);
        this.itemsRepository.save(item);
    }

    @Transactional
    @DeleteMapping("/{id}")
    void deleteItem( @PathVariable Long id) {
        this.itemsRepository.deleteById(id);
    }

    @Transactional
    @PutMapping("{id}")
    void updateDescription(@PathVariable Long id, @RequestBody Items item) {
        this.itemsRepository.updateDescription(id, item.getDescription());
    }

    @Transactional
    @PutMapping("/updateCompleted/{id}")
    void updateCompleted(@PathVariable Long id, @RequestBody Items item) {
        this.itemsRepository.updateCompleted(id,item.isCompleted());
    }

    @GetMapping("/getCompletedFalse")
    List<Items> getCompletedFalse() {
        return this.itemsRepository.findByCompletedFalse();
    }
}
