package com.example.springbootapp.login.repository;

import com.example.springbootapp.login.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
