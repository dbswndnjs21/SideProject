package com.sideproject.controller;

import com.sideproject.dto.UserDto;
import com.sideproject.dto.UserEntityDto;
import com.sideproject.entity.UserEntity;
import com.sideproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 사용자 목록 반환
    @GetMapping
    public List<UserEntityDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
