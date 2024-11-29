package com.mysite.pothole_capstone;

import com.mysite.pothole_capstone.user.UserRepository;
import com.mysite.pothole_capstone.user.User;
import com.mysite.pothole_capstone.pothole.PotholeRepository;
import com.mysite.pothole_capstone.pothole.Pothole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.swing.text.html.Option;

import java.io.File;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*@SpringBootTest
class PotholeCapstoneApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PotholeRepository potholeRepository;

    @Test
    void contextLoads() {

    }
}
*/

/*
--------없는 이미지는 전부 제거--------
private final String image_path = "src/main/resources/static/pothole_images/";
List<Pothole> ods = this.potholeRepository.findAll();
        File file = new File(image_path);
        File[] files = file.listFiles();

        for(Pothole pothole : ods){
            int index = 0;
            String imageFileName = pothole.getImagePath();
            if(files!=null){
                for(File oa : files){
                    String fileName = oa.getName();
                    if (imageFileName.equals(fileName)) {
                        index = 1;
                        break;
                    }
                }
            }
            if(index == 0){
                this.potholeRepository.delete(pothole);
            }
        }
---------------------------
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