package com.lotteeatzclone.java.eatzmain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EatzMainController {

  @GetMapping("/")
  public String mainpage() {

    return "/basic/index";
  }
}
