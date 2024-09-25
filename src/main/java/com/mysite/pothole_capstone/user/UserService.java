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
    public boolean isID_valid(String userid, String password){ return userRepository.existsByUserIDAndPassword(userid, password); }
    public User create(String username, String userid, String password, String email) { //회원가입 기능
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
    public String findId(String username, String email){ //회원 아이디를 찾기 위함(아이디 찾기 기능)
        Optional<User> oa = this.userRepository.findByUsernameAndEmail(username, email);
        if(oa.isPresent()){
            return oa.get().getUserID();
        }
        else{
            return null;
        }
    }
    public boolean findPasswd(String userid, String username, String email){ //회원 비밀번호 찾기 위함(비밀번호 찾기 기능)
        Optional<User> oa = this.userRepository.findByUserIDAndUsernameAndEmail(userid, username, email);
        if(oa.isPresent()){
            return true;
        }else{
            return false;
        }
    }
    public User modifyPasswd(String userId, String username, String email, String tempPWD){ //기존 비밀번호에서 임시 비밀번호로 변경
        Optional<User> oa = this.userRepository.findByUserIDAndUsernameAndEmail(userId, username, email);
        if(oa.isPresent()){
            User siteuser = User.builder()
                    .id(oa.get().getId())
                    .username(oa.get().getUsername())
                    .userID(oa.get().getUserID())
                    .email(oa.get().getEmail())
                    .password(passwordEncoder.encode(tempPWD))
                    .build();
            this.userRepository.save(siteuser);
            return siteuser;
        }
        else{
            return null;
        }
    }
    public User modifyEmailOrPasswd(String userid, String username, String email, String passwd){ //기존 비밀번호에서 임시 비밀번호로 변경
        Optional<User> oa = this.userRepository.findByUserIDAndUsername(userid, username);
        if(oa.isPresent()){
            User siteuser = User.builder()
                    .id(oa.get().getId())
                    .username(oa.get().getUsername())
                    .userID(oa.get().getUserID())
                    .email(email)
                    .password(passwordEncoder.encode(passwd))
                    .build();
            this.userRepository.save(siteuser);
            return siteuser;
        }
        else{
            return null;
        }
    }
    public User findUser(String userid){
        Optional<User> oa = this.userRepository.findByUserID(userid);
        if(oa.isPresent()){
            return oa.get();
        }
        else{
            throw new NoSuchElementException("회원정보 오류");
        }
    }
}
