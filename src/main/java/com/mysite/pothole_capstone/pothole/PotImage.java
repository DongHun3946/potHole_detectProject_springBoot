package com.mysite.pothole_capstone.pothole;

import com.mysite.pothole_capstone.pothole.Pothole;
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
public class PotImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagePath;

    private String imageName;

    @ManyToOne
    private Pothole pothole;
}
