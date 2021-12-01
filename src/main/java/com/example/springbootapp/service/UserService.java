package com.example.springbootapp.service;

import com.example.springbootapp.domain.User;
import com.example.springbootapp.dto.UserDTO;
import com.example.springbootapp.repository.UserRepository;
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

    public UserDTO 회원가입(UserDTO dto) {

        User user = userRepository.save(dto.toEntity());

        modelMapper.map(user, dto);

        return dto;
    }
}
