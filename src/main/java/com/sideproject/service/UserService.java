package com.sideproject.service;

import com.sideproject.dto.UserEntityDto;
import com.sideproject.entity.UserEntity;
import com.sideproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntityDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(UserEntityDto::new) // UserEntity를 UserEntityDto로 변환
                .collect(Collectors.toList());
    }

    public UserEntityDto getUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username);
        return new UserEntityDto(user);
    }

    public Long getUserIdfromUsername(String username) {
        return userRepository.findByUsername(username)
                .getId();
    }
}
