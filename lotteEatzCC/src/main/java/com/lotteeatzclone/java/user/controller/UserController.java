package com.lotteeatzclone.java.user.controller;

import java.sql.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.lotteeatzclone.java.user.domain.User;
import com.lotteeatzclone.java.user.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping("/login")
  public String login() {
    return "basic/login";
  }

  @GetMapping("/regist")
  public String regist(Model model) {
    model.addAttribute("title", "회원가입");
    model.addAttribute("path", "/user/regist");
    model.addAttribute("content", "registFragment");
    model.addAttribute("contentHead", "registFragmentHead");

    return "basic/regist";
  }


  @PostMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate(); // 세션 전체를 무효화하는 것이 좋습니다.
    return "redirect:/"; // 메인 페이지 또는 로그인 페이지로 리디렉션
  }

  @PostMapping("/regist")
  public String registPost(@RequestParam Map<String, String> map, Model model) {
    try {
      User newUser = new User(null, map.get("userId"), map.get("userPassword"), map.get("name"),
          map.get("phone"), !map.get("birth").isEmpty() ? Date.valueOf(map.get("birth")) : null,
          null, map.get("member"));

      userService.add(newUser);

      return "basic/login";
    } catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("requestError", "회원가입 실패");
      model.addAttribute("title", "회원가입");
      model.addAttribute("path", "/user/regist");
      model.addAttribute("content", "registFragment");
      model.addAttribute("contentHead", "registFragmentHead");

      return "basic/login"; // 오류 발생 시 다시 회원가입 페이지로 이동
    }
  }

  @PostMapping("/login")
  public String loginPost(@RequestParam Map<String, String> map, HttpSession session) {
    String userId = map.get("userId");
    String password = map.get("userPassword");

    if (userId == null || password == null) {

      return "basic/login";
    }

    User user = new User();
    user.setUserId(userId);
    user.setUserPassword(password);

    User loggedInUser = userService.login(user);

    if (loggedInUser != null) {
      session.setAttribute("userName", loggedInUser.getName());
      session.setAttribute("userId", loggedInUser.getId());
      return "redirect:/";
    } else {
      // 로그인 실패 처리
      return "basic/login";
    }
  }

}
