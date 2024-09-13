package com.mysite.pothole_capstone.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/signup") //회원가입을 위한 템플릿 렌더링
    public String signup(Model model){
        model.addAttribute("UserCreateForm", new UserCreateForm());
        return "signup";
    }
    @PostMapping("/signup") //회원가입 요청
    public String signup(@Valid UserCreateForm userCreateForm,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "signup";
        }
        if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())){
            bindingResult.rejectValue("password2", "passwordIncorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup";
        }
        try{
            userService.create(userCreateForm.getUsername(),
                    userCreateForm.getUserID(), userCreateForm.getPassword1(),
                    userCreateForm.getEmail());
        }
        catch(DataIntegrityViolationException e){
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup";
        }
        catch(Exception e){
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup";
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){return "login";}

}
