package com.example.AsterTT.repository;

import com.example.AsterTT.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface TasksRepo extends JpaRepository<Tasks, Integer> {
    Tasks findById(int id);

    List<Tasks> findAll();
    List<Tasks> findAllByDoneIsTrueOrderById();
    List<Tasks> findAllByDoneIsFalseOrderById();


    @Modifying
    @Transactional
    @Query("update Tasks task set task.done = false where task.id = ?1")
    void update(int id);

    @Modifying
    @Transactional
    @Query("delete Tasks task where task.id = ?1")
    void deleteById(int id);

}
