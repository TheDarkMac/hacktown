package com.hei.hackathon.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDoListDto {
    private long id;
    private String signature;
    private String name;
    private String userName;
}
