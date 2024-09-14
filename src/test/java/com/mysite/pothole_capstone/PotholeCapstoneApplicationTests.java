package com.mysite.pothole_capstone;

import com.mysite.pothole_capstone.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.mysite.pothole_capstone.user.User;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.*;

@SpringBootTest
class PotholeCapstoneApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Test
    void contextLoads() {
        Optional<User> oa = this.userRepository.findById(8L);
        assertTrue(oa.isPresent());
        User a = oa.get();
        this.userRepository.delete(a);
    }
}
