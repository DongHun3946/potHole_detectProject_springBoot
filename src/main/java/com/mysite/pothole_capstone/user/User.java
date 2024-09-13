package com.mysite.pothole_capstone.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   //기본키

    @Column(columnDefinition = "TEXT")
    private String username;

    @Column(unique = true)
    private String userID;   //회원 아이디

    private String password; //회원 비밀번호

    @Column(unique = true)
    private String email;  //회원 이메일

    @Builder.Default
    private boolean isManager = false; //관리자인지 일반회원인지 구별하는 변수
}
