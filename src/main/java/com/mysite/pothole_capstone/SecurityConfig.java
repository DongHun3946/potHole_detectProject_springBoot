package com.mysite.pothole_capstone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration     //스프링의 설정 클래스임을 나타내는 어노테이션
@EnableWebSecurity //스프링시큐리티를 활성화시키는 어노테이션
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                //인증하지 않은 모든 페이지의 요청을 허락한다.
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests
                                .requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
                .formLogin((formLogin) -> formLogin
                        .loginPage("/user/login")    //로그인 페이지 경로 : /user/login
                        .defaultSuccessUrl("/main")) // 로그인 성공 시 이동할 경로 : /main

                .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")) //사용자가 /user/logout 경로로 요청을 보내면 로그아웃 처리
                        .logoutSuccessUrl("/user/login")  //로그아웃 후 이동할 경로 : /login
                        .invalidateHttpSession(true));    //로그아웃 후 세션을 무효화
        return http.build();
    }
    @Bean
    PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();} //비밀번호 인코더를 정의(비밀번호 암호화)

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager(); //기본 인증 관리자를 가져와 반환
    }
}
