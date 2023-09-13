package com.example.AsterTT.repository;

import com.example.AsterTT.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TasksRepo extends JpaRepository<Tasks, Integer> {
    Tasks findById(int id);

    List<Tasks> findAll();
    List<Tasks> findAllByDoneIsTrueOrderById();
    List<Tasks> findAllByDoneIsFalseOrderById();


}
