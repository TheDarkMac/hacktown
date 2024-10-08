package com.hei.hackathon.hackathon.repository;

import com.hei.hackathon.hackathon.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
