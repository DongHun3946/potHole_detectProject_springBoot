package com.mysite.pothole_capstone.pothole;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.security.Principal;

@Controller
@RequestMapping("/pothole")
public class PotholeController {
    @GetMapping("/main")
    public String main(Model model, Principal principal){
        String username = principal.getName();
        model.addAttribute("username", username);
        return "main";
    }
}
