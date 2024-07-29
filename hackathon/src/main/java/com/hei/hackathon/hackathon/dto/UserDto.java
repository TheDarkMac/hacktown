package com.hei.hackathon.hackathon.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String uname;
    private String userName;
    private String email;
    private String password;
    private Set<ToDoListDto> toDoListDtos = new HashSet<>();
}
