package com.hei.hackathon.hackathon.controller;

import com.hei.hackathon.hackathon.dto.ToDoListDto;
import com.hei.hackathon.hackathon.services.TodoListServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/back/data")
public class ToDoListController {
    TodoListServices todoListServices;
    @GetMapping("/todoLists")
    public ResponseEntity<List<ToDoListDto>> getToDoLists() {
        List<ToDoListDto> todoLists = todoListServices.getAllTodoList();
        System.out.println(todoLists);
        return ResponseEntity.ok(todoLists);
    }
}
