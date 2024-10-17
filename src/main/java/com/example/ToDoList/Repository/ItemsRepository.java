package com.example.ToDoList.Repository;

import com.example.ToDoList.Models.Items;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ItemsRepository extends ListCrudRepository<Items, Long> {

    List<Items> findByCompletedFalse();

    @Modifying
    @Query("UPDATE Items s SET s.description = :description WHERE s.id = :id")
    void updateDescription(Long id, String description);

    @Modifying
    @Query("UPDATE Items s SET s.completed = :completed WHERE s.id = :id")
    void updateCompleted(Long id, boolean completed);
}
