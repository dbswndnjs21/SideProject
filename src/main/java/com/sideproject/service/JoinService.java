package com.sideproject.service;

import com.sideproject.dto.JoinDTO;
import com.sideproject.entity.UserEntity;
import com.sideproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void joinProcess(JoinDTO joinDTO) {
        String username = joinDTO.getUsername();
        String password = joinDTO.getPassword();

        Boolean isExists = userRepository.existsByUsername(username);

        if (isExists) {
            return;
        }

        UserEntity userEntity = UserEntity.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role("ROLE_ADMIN")
                .build();

        userRepository.save(userEntity);

    }
}
