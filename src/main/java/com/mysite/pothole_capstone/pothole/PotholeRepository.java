package com.mysite.pothole_capstone.pothole;

import com.mysite.pothole_capstone.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PotholeRepository extends JpaRepository<Pothole, Integer> {
    Page<Pothole> findByUser(User user, Pageable pageable);
    Page<Pothole> findByState(String state, Pageable pageable);
    Integer countByUserAndStateContaining(User user, String keyword);


}
