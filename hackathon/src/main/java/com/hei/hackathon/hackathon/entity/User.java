package com.hei.hackathon.hackathon.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    private String userName;

    @Column(name = "Uname", nullable = false)
    private String uname;


    @Column(name = "email", nullable = false)
    private String email;


    @Column (name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ToDoList> toDoLists;
}
