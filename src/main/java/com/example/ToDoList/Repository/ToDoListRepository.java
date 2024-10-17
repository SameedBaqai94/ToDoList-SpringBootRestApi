package com.example.ToDoList.Repository;

import com.example.ToDoList.Models.ToDoList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ToDoListRepository extends ListCrudRepository<ToDoList, Long> {

    Optional<ToDoList> findById(Long id);
    Optional<ToDoList> findByTitle(String title);

    @Modifying
    @Query("UPDATE ToDoList t SET t.title = :title WHERE t.id = :id")
    void updateToDoListById(@Param("id") Long id, @Param("title") String title);


}
