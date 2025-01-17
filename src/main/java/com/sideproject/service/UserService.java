package com.sideproject.service;

import com.sideproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Long getUserIdfromUsername(String username) {
        return userRepository.findByUsername(username)
                .getId();
    }
}
