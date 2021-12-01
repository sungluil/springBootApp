package com.example.springbootapp.login.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
@Entity
@Table(name = "ST_USER")
@Builder
public class User {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String pw;
}
