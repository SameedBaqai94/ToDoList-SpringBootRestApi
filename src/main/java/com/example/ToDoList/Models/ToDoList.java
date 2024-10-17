package com.example.ToDoList.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @OneToMany(mappedBy = "toDoList",cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Items> items;


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
