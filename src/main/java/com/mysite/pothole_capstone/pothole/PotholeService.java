package com.mysite.pothole_capstone.pothole;

import com.mysite.pothole_capstone.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mysite.pothole_capstone.user.User;

import java.time.LocalDateTime;
import java.util.*;
@RequiredArgsConstructor
@Service
public class PotholeService {
    private final PotholeRepository potholeRepository;

    public Pothole create(double latitude, double longitude, String addr,
                          String state, List<PotImage> imgList, User findUser){
        Pothole oa = Pothole.builder()
                .latitude(latitude)
                .longitude(longitude)
                .address(addr)
                .state(state)
                .detectDate(LocalDateTime.now())
                .image(imgList)
                .user(findUser)
                .build();
        this.potholeRepository.save(oa);
        return oa;
    }
}
