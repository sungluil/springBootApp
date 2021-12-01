package com.example.springbootapp.dto;

import com.example.springbootapp.domain.User;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String pw;

    public User toEntity() {
        return User.builder()
                .id(id)
                .email(email)
                .name(name)
                .pw(pw)
                .build();
    }
}
