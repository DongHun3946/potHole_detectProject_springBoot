package com.mysite.pothole_capstone;

import com.mysite.pothole_capstone.user.UserRepository;
import com.mysite.pothole_capstone.user.User;
import com.mysite.pothole_capstone.pothole.PotholeRepository;
import com.mysite.pothole_capstone.pothole.Pothole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.*;

@SpringBootTest
class PotholeCapstoneApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PotholeRepository potholeRepository;

    @Test
    void contextLoads() {
        Pothole p = Pothole.builder()
                .latitude()
                .longitude()
                .address()
                .state()
                .detectDate()
                .image()
                .user()
                .build();
        this.potholeRepository.save(p);
    }
}
/*
--------데이터 저장---------
User p = User.builder()
    .username("매니저")
    .userID("manager")
    .password("1234")
    .email("cdh3946@gmail.com")
    .isManager(true)
    .build();
this.userRepository.save(p);

Pothole p = Pothole.builder()
    .latitude()
    .longitude()
    .address()
    .state()
    .detectDate()
    .image()
    .user()
    .build();
this.potholeRepository.save(p);
---------------------------

--------데이터 조회---------
Optional<User> oa = this.placeRepository.findById(10L);
assertTrue(oa.isPresent());
User a = oa.get();
---------------------------

--------데이터 삭제---------
Optional<User> oa = this.userRepository.findById(11L);
assertTrue(oa.isPresent());
User p = oa.get();
this.userRepository.delete(p);
---------------------------

--------데이터 수정---------

Optional<User> oa = this.userRepository.findById(11L);
assertTrue(oa.isPresent());
User p = oa.get();

User update = User.builder()
    .id(p.getId())
    .username(p.getUsername())
    .userID(p.getUserID())
    .password(p.getPassword())
    .email(p.getEmail())
    .isManager(true)
    .build();
this.userRepository.save(update);
 */