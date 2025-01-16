package com.sideproject.dto;

import com.sideproject.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntityDto {
    private Long id;
    private String username;
    private String password;
    private String role;

    // 생성자: UserEntity를 받아서 UserEntityDto로 변환
    public UserEntityDto(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.password = userEntity.getPassword();
        this.role = userEntity.getRole();
    }

    // toEntity 메서드: UserEntityDto를 UserEntity로 변환
    public UserEntity toEntity() {
        return UserEntity.builder()
                .id(this.id)
                .username(this.username)
                .password(this.password)
                .role(this.role) .
                build(); }
}
