package com.hei.hackathon.hackathon.repository;

import com.hei.hackathon.hackathon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
