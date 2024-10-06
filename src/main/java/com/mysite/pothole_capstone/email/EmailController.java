package com.mysite.pothole_capstone.email;

import com.mysite.pothole_capstone.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;
    @PostMapping("/user/findPW")
    public String sendEmail(@RequestParam String email, @RequestParam String userid,
                            @RequestParam String username, Model model){
        if(userService.findPasswd(userid, username, email)){
            model.addAttribute("sendEmail", "임시 비밀번호를 이메일로 전송했습니다.");
            String tempPWD = TempPwdGenerator.generateTempPasswd();  //tempPWD 에 임시비밀번호 저장
            emailService.sendTempPasswd(email, tempPWD);   //이메일로 임시 비밀번호 송신
            userService.modifyPasswd(userid, username, email, tempPWD);
        }
        else{
            model.addAttribute("error", "입력하신 정보는 존재하지 않습니다.");
        }
        return "findPwd";
    }
}
