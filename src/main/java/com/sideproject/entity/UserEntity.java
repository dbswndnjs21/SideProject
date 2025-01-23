package com.sideproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 때문에 쓰는건데 entity를 복사해서 가져올때 프록시가 noargs로 바꿈
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private String role;
    private String picUrl;
    private Integer isWithdrawal;
    // Room과의 ManyToMany 관계를 RoomParticipant를 통해 간접적으로 설정
    @OneToMany(mappedBy = "user")
    private List<RoomParticipant> roomParticipants;
}
