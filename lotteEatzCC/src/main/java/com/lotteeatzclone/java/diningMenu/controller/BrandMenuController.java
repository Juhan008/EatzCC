package com.lotteeatzclone.java.diningMenu.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lotteeatzclone.java.diningMenu.domain.DiningMenu;
import com.lotteeatzclone.java.diningMenu.service.DiningMenuService;

@RestController
public class BrandMenuController {
  private final DiningMenuService diningMenuService;

  public BrandMenuController(DiningMenuService diningMenuService) {
    this.diningMenuService = diningMenuService;
  }

  @GetMapping("/brandhotmanu")
  public List<DiningMenu> getMenusByBrand(@RequestParam(name = "brand") String brand,
      @RequestParam(name = "mainMenu", defaultValue = "a") String mainMenu) {
    return diningMenuService.getMenusByBrandAndMainMenu(brand, mainMenu);
  }

  @GetMapping("/recommend")
  public ResponseEntity<List<DiningMenu>> getHotMenus(@RequestParam(name = "brand") String brand) {
    List<DiningMenu> menus = diningMenuService.findHotMenusByBrand(brand);
    return ResponseEntity.ok(menus);
  }

  @GetMapping("/menus")
  public ResponseEntity<List<DiningMenu>> getMenusByCategory(
      @RequestParam(name = "category") String category) {
    List<DiningMenu> menus = diningMenuService.findMenusByCategory(category);
    return ResponseEntity.ok(menus);
  }

  @GetMapping("/recommendbtn")
  public ResponseEntity<List<DiningMenu>> getHotMenus(@RequestParam(name = "brand") String brand,
      @RequestParam(name = "hotMenu", defaultValue = "추천") String hotMenu) {
    List<DiningMenu> menus = diningMenuService.getHotMenus(brand, hotMenu);
    return ResponseEntity.ok(menus);
  }
}

