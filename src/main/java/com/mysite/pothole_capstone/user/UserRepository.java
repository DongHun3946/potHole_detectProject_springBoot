package com.mysite.pothole_capstone.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserID(String userid);
    Optional<User> findById(Long id);
    Optional<User> findByUsernameAndEmail(String username, String email);
    boolean existsByUserID(String userid);
    boolean existsByEmail(String email);
}
