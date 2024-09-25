package com.mysite.pothole_capstone.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserID(String userid);
    Optional<User> findByUsernameAndEmail(String username, String email);
    Optional<User> findByUserIDAndUsernameAndEmail(String userId, String username, String email);
    Optional<User> findByUserIDAndUsername(String userid, String username);
    boolean existsByUserIDAndPassword(String userid, String password);
    boolean existsByUserID(String userid);
    boolean existsByEmail(String email);
}
