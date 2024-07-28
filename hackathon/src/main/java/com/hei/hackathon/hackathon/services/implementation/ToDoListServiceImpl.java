package com.hei.hackathon.hackathon.services.implementation;

import com.hei.hackathon.hackathon.dto.ToDoListDto;
import com.hei.hackathon.hackathon.entity.ToDoList;
import com.hei.hackathon.hackathon.mapper.ToDoMapper;
import com.hei.hackathon.hackathon.repository.ToDoListRepository;
import com.hei.hackathon.hackathon.services.TodoListServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoListServiceImpl implements TodoListServices {
    ToDoListRepository toDoListRepository;

    @Override
    public List<ToDoListDto> getAllTodoList() {
        List<ToDoList> todoLists = toDoListRepository.findAll();
        return todoLists
                .stream().map(ToDoMapper::mapToToDoDto)
                .toList();
    }

    @Override
    public ToDoList getTodoListByUserId(String userId) {
        return null;
    }

    @Override
    public ToDoList createTodoList(ToDoList todoList) {
        return null;
    }

    @Override
    public ToDoList updateTodoList(ToDoList todoList) {
        return null;
    }

    @Override
    public ToDoList deleteTodoListById(String todoListId) {
        return null;
    }
}
