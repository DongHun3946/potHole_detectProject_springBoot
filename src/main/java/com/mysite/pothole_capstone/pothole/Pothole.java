package com.mysite.pothole_capstone.pothole;

import com.mysite.pothole_capstone.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Pothole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //일련번호

    private double latitude; //위도

    private double longitude; //경도

    @Column(columnDefinition = "TEXT")
    private String address; //주소

    @Column(columnDefinition = "TEXT")
    private String state;  //상태

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime detectDate; //탐지일자

    private String imagePath;

    @ManyToOne
    private User user; //회원
}
