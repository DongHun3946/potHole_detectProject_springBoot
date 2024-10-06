package com.mysite.pothole_capstone.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendTempPasswd(String toEmail, String tempPasswd){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("임시 비밀번호 발급");
        message.setText("안녕하세요 요청하신 임시 비밀번호는 다음과 같습니다 : " + tempPasswd);
        message.setFrom(fromEmail);

        javaMailSender.send(message);
    }
}
