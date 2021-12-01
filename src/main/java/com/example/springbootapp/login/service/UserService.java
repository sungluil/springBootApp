package com.example.springbootapp.login.service;

import com.example.springbootapp.commons.annotation.LogAspect;
import com.example.springbootapp.login.domain.User;
import com.example.springbootapp.login.dto.UserDTO;
import com.example.springbootapp.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @LogAspect
    public UserDTO 회원가입(UserDTO dto) {
        log.info("회원가입 서비스 >>>>>>");
        User user = userRepository.save(dto.toEntity());
        modelMapper.map(user, dto);
        return dto;
    }
}
