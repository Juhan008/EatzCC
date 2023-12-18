package com.lotteeatzclone.java.eatzmain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.lotteeatzclone.java.user.domain.User;
import jakarta.servlet.http.HttpSession;

@Controller
public class EatzMainController {

  @GetMapping("/")
  public String mainPage(Model model, HttpSession session) {
    // 세션에서 사용자 정보를 가져옴
    User user = (User) session.getAttribute("user");
    if (user != null) {
      // 모델에 사용자 이름 추가
      model.addAttribute("userName", user.getName());
    }

    return "/basic/index";
  }
}
