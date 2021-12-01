package com.example.springbootapp.login.controller;

import com.example.springbootapp.commons.annotation.LogAspect;
import com.example.springbootapp.login.dto.UserDTO;
import com.example.springbootapp.login.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    @LogAspect
    public ResponseEntity join(@RequestBody UserDTO dto) {
        log.info("회원가입 데이터 {}", dto);
        UserDTO userDTO = userService.회원가입(dto);
        return ResponseEntity.ok().body(userDTO);
    }
}
