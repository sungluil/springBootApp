package com.example.springbootapp.controller;

import com.example.springbootapp.dto.UserDTO;
import com.example.springbootapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity join(@RequestBody UserDTO dto) {
        log.info("회원가입 데이터 {}", dto);
        UserDTO userDTO = userService.회원가입(dto);
        return ResponseEntity.ok().body(userDTO);
    }
}
