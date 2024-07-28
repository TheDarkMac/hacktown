package com.hei.hackathon.hackathon.services.implementation;

import com.hei.hackathon.hackathon.dto.ToDoListDto;
import com.hei.hackathon.hackathon.entity.ToDoList;
import com.hei.hackathon.hackathon.exceptions.ResourceNotFoundException;
import com.hei.hackathon.hackathon.mapper.ToDoMapper;
import com.hei.hackathon.hackathon.repository.ToDoListRepository;
import com.hei.hackathon.hackathon.services.TodoListServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
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
    public ToDoListDto getTodoListById(String toDoId) {
        ToDoList toDoList = toDoListRepository.findById(toDoId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("To do list with id " + toDoId + " not found"));
        return ToDoMapper.mapToToDoDto(toDoList);
    }

    @Override
    public ToDoListDto  createTodoList(ToDoListDto toDo) {
        ToDoList createdToDoList = toDoListRepository.save(ToDoMapper.mapToToDoList(toDo));
        return ToDoMapper.mapToToDoDto(createdToDoList);
    }

    @Override
    public String  updateTodoList(String todoId, ToDoListDto todoDto) {
        ToDoList toDo = toDoListRepository.findById(todoId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("To do list with id " + todoId + " not found"));
        toDo.setName(todoDto.getName());
        return "To do list updated successfully !";
    }

    @Override
    public String deleteTodoListById(String todoId) {
        toDoListRepository.deleteById(todoId);
        return "To do list deleted with success !";
    }
}
