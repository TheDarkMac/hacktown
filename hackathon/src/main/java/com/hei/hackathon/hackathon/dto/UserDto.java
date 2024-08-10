package com.hei.hackathon.hackathon.dto;

import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String uname;
    private String userName;
    private String email;
    private String password;
    private List<ToDoListDto> toDoListDtos = new ArrayList<>();
}
