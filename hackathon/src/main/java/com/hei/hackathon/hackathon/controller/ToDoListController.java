package com.hei.hackathon.hackathon.controller;

import com.hei.hackathon.hackathon.dto.ToDoListDto;
import com.hei.hackathon.hackathon.dto.UserDto;
import com.hei.hackathon.hackathon.entity.User;
import com.hei.hackathon.hackathon.mapper.UserMapper;
import com.hei.hackathon.hackathon.services.TodoListServices;
import com.hei.hackathon.hackathon.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/back/data")
public class ToDoListController {
    TodoListServices todoListServices;
    UserService userService;

    @GetMapping("/todoLists")
    public ResponseEntity<List<ToDoListDto>> getToDoLists() {
        List<ToDoListDto> todoLists = todoListServices.getAllTodoList();
        return ResponseEntity.ok(todoLists);
    }

    @GetMapping("/todoLists/{toDoListId}")
    public ResponseEntity<ToDoListDto> getToDoList(@PathVariable("toDoListId") String toDoListId) {
        ToDoListDto toDoList = todoListServices.getTodoListById(toDoListId);
        return ResponseEntity.ok(toDoList);
    }

    @PostMapping("/todoLists/add")
    public ResponseEntity<ToDoListDto> addToDoList(@RequestBody ToDoListDto toDoListDto) {
        UserDto userDto = userService.getUserById(toDoListDto.getUserName());
        User user = UserMapper.MapToUser(userDto);

        ToDoListDto addedToDoList = todoListServices.createTodoList(toDoListDto, user);

        return new ResponseEntity<>(addedToDoList, HttpStatus.CREATED);
    }

    @PutMapping("/todoLists/update/{id}")
    public ResponseEntity<ToDoListDto> updateToDoList(@PathVariable("id") String id, @RequestBody ToDoListDto toDoListDto) {
        ToDoListDto updatedToDoList = todoListServices.updateTodoList(id,toDoListDto);
        return ResponseEntity.ok(updatedToDoList);
    }

    @DeleteMapping("/todoLists/delete/{id}")
    public ResponseEntity<String> deleteToDoList(@PathVariable("id") String id) {
        todoListServices.deleteTodoListById(id);
        return ResponseEntity.ok("To do list deleted with success !");
    }

}
