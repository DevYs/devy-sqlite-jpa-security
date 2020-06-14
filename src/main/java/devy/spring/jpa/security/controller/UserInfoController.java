package devy.spring.jpa.security.controller;

import devy.spring.jpa.security.domain.UserInfo;
import devy.spring.jpa.security.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/user/add")
    public String addUserGet() {
        return "user/user_add";
    }

    @PostMapping("/user/add")
    public String addUserPost(UserInfo userInfo) {
        userInfoService.addUser(userInfo);
        return "redirect:/";
    }

}
