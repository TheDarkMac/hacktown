package com.hei.hackathon.hackathon.controller;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/back/data")
public class ToDoListController {
    @GetMapping("/todoLists")
    public List<ToDoList> getToDoLists() {

    }
}
