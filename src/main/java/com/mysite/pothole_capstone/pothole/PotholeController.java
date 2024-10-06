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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.Console;
import java.security.Principal;
import java.util.List;
import java.util.Map;

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
    public String manage1(Model model, Principal principal,
                          @RequestParam(value = "select", defaultValue = "null") String select,
                          @RequestParam(value = "page", defaultValue = "0") int page) {
        String userId = principal.getName();
        User user = userService.findUser(userId);
        String username = user.getUsername();
        model.addAttribute("username", username);

        Page<Pothole> paging = null;
        if (select.equals("null") || select.equals("6")) {
            paging = this.potholeService.getListAll(page);
        } else {
            paging = this.potholeService.getSelectList(select, page);
        }
        model.addAttribute("paging", paging);
        model.addAttribute("selectedOption", select);

        List<Pothole> potholes = this.potholeService.getLocation();
        model.addAttribute("potholes", potholes);

        return "manage";
    }
    @PostMapping("/manage/save")
    public String manageSave(@RequestParam(value = "selectedRow", required = false) Integer id,
                             @RequestParam Map<String, String> stateMap,
                             RedirectAttributes redirectAttributes) {
        String state = stateMap.get("stateMap[" + id + "]");
        try {
            this.potholeService.modifyState(state, id);
            redirectAttributes.addFlashAttribute("successMessage", "포트홀 상태가 성공적으로 업데이트 되었습니다.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "포트홀 상태 업데이트 중 오류가 발생했습니다.");
        }
        return "redirect:/pothole/manage";
    }
    @PostMapping("/manage")
    public String manage2(Model model, Principal principal,
                          @RequestParam(value = "select", defaultValue = "null") String select,
                          @RequestParam(value = "page", defaultValue = "0") int page) {
        String userId = principal.getName();
        User user = userService.findUser(userId);
        String username = user.getUsername();
        model.addAttribute("username", username);
        model.addAttribute("selectedOption", select);

        Page<Pothole> oa = this.potholeService.getSelectList(select, page);
        model.addAttribute("paging", oa);

        List<Pothole> potholes = this.potholeService.getLocation();
        model.addAttribute("potholes", potholes);

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