package com.mysite.pothole_capstone.user;

import com.mysite.pothole_capstone.DataNotFoundException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
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

    public String findId(String username, String email){ //회원 아이디를 찾기 위함
        Optional<User> oa = this.userRepository.findByUsernameAndEmail(username, email);
        if(oa.isPresent()){
            return oa.get().getUserID();
        }
        else{
            return null;
        }
    }
}
