package com.hei.hackathon.hackathon.repository;

import com.hei.hackathon.hackathon.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, String> {
}
