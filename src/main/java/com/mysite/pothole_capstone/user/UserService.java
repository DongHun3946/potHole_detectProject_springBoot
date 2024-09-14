package com.mysite.pothole_capstone.user;

import com.mysite.pothole_capstone.DataNotFoundException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean isID_duplicate(String userID){
        return userRepository.existsByUserID(userID);
    }
    public boolean isEmail_duplicate(String email){
        return userRepository.existsByEmail(email);
    }
    public User create(String username, String userid, String password, String email) {
        User siteuser = User.builder()
                .username(username)
                .userID(userid)
                .password(passwordEncoder.encode(password))
                .email(email)
                .isManager(false)
                .build();
        this.userRepository.save(siteuser);

        return siteuser;
    }
    public User getUser(String userID){ //회원 정보를 얻기 위함
        Optional<User> siteUser = this.userRepository.findByUserID(userID);
        if(siteUser.isPresent()){
            return siteUser.get();
        }else{
            throw new DataNotFoundException("유저 정보가 없습니다.");
        }
    }
}
