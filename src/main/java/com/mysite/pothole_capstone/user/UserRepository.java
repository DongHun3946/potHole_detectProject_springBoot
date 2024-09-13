package com.mysite.pothole_capstone.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserID(String userid);
}
