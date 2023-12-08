package com.lotteeatzclone.java.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {
  @GetMapping("/map")
  public String getMap(Model model) {

    return "/map/mapBox";
  }
}
