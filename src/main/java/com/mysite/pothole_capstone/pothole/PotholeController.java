package com.mysite.pothole_capstone.pothole;

import com.mysite.pothole_capstone.user.UserService;
import com.mysite.pothole_capstone.pothole.PotholeService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import com.mysite.pothole_capstone.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/pothole")
public class PotholeController {
    @Autowired
    private UserService userService;
    @Autowired
    private PotholeService potholeService;

    @GetMapping("/main")
    public String main(Model model, Principal principal,
                       @RequestParam(value = "page", defaultValue = "0") int page) { //ex)http://localhost:8080/pothole/main?page=1 에서 value=page 이고 1은 int main을 의미함
        String userId = principal.getName();
        User user = userService.findUser(userId);
        String username = user.getUsername();
        model.addAttribute("username", username);

        Page<Pothole> paging = this.potholeService.getList(user, page);
        model.addAttribute("paging", paging);

        List<Integer> reportCnt = potholeService.getCount(user, "");
        model.addAttribute("cnt", reportCnt);
        return "main";
    }

    @GetMapping("/manage")
    public String manage1(Model model, Principal principal, @RequestParam(value = "select", required = false) String select,
                         @RequestParam(value = "page", defaultValue = "0") int page) {
        String userId = principal.getName();
        User user = userService.findUser(userId);
        String username = user.getUsername();
        model.addAttribute("username", username);

        Page<Pothole> paging = this.potholeService.getListAll(page);
        model.addAttribute("paging", paging);
        model.addAttribute("selectedOption", select); // select 값 모델에 추가
        return "manage";
    }

    @PostMapping("/manage")
    public String manage2(Model model, Principal principal, @RequestParam("select") String select,
                         @RequestParam(value = "page", defaultValue = "0") int page) {
        String userId = principal.getName();
        User user = userService.findUser(userId);
        String username = user.getUsername();
        model.addAttribute("username", username);
        model.addAttribute("selectedOption", select);

        Page<Pothole> oa = null;

        switch (select) {
            case "1":
                oa = this.potholeService.getRadioList("접수 중", page);
                break;
            case "2":
                oa = this.potholeService.getRadioList("접수 실패", page);
                break;
            case "3":
                oa = this.potholeService.getRadioList("접수 완료", page);
                break;
            case "4":
                oa = this.potholeService.getRadioList("수리 중", page);
                break;
            case "5":
                oa = this.potholeService.getRadioList("수리 완료", page);
                break;
            case "6":
                oa = this.potholeService.getListAll(page);
                break;
            default:
                break;
        }

        model.addAttribute("paging", oa);
        return "manage";
    }

    @GetMapping("/access-denied") //관리자만 허용하기 위함
    public String accessDenied() {
        return "accessDenied";
    }

    @GetMapping("/stats")
    public String stats() {
        return "stats";
    }

}
