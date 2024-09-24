package com.mysite.pothole_capstone.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userID) throws UsernameNotFoundException {
        Optional<User> oa = this.userRepository.findByUserID(userID);
        if(oa.isEmpty()){
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        User siteUser = oa.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(siteUser.isManager()){ //isManager 변수가 true 면 MANAGER 권한 부여
            authorities.add(new SimpleGrantedAuthority(UserRole.MANAGER.getValue()));
        }
        else{
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }
        return new org.springframework.security.core.userdetails.User(siteUser.getUserID(), siteUser.getPassword(), authorities);
    }
}
