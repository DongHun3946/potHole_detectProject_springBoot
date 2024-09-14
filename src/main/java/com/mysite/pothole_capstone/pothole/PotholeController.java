package com.mysite.pothole_capstone.pothole;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pothole")
public class PotholeController {
    @GetMapping("/main")
    public String main(){
        return "main";
    }

}
