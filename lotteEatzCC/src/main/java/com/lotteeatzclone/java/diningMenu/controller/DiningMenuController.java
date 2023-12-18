package com.lotteeatzclone.java.diningMenu.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.lotteeatzclone.java.diningMenu.domain.DiningMenu;
import com.lotteeatzclone.java.diningMenu.service.DiningMenuService;

@Controller
public class DiningMenuController {
  private final DiningMenuService diningMenuService;

  @Autowired
  public DiningMenuController(DiningMenuService diningMenuService) {
    this.diningMenuService = diningMenuService;
  }

  @GetMapping("/admin/menuadd")
  public String showRegistrationPage() {
    return "/admin/menuadd";
  }

  @PostMapping("/submitMenu")
  public String submitMenu(@RequestParam("menuName") String menuName,
      @RequestParam("brand") String brand, @RequestParam("category") String category,
      @RequestParam("image") MultipartFile file, @RequestParam("weight") String weight,
      @RequestParam("calories") String calories, @RequestParam("protein") String protein,
      @RequestParam("sodium") String sodium, @RequestParam("sugar") String sugar,
      @RequestParam("saturatedFat") String saturatedFat, @RequestParam("allergy") String allergy,
      @RequestParam("origin") String origin) {
    try {
      // 이미지 파일 처리
      String filename =
          UUID.randomUUID().toString().substring(0, 8) + "_" + file.getOriginalFilename();
      Path path = Paths.get(
          "/Users/limjuhan/eclipse-workspace/lotteEatzCC/src/main/resources/static/images/menu/"
              + filename);
      Files.copy(file.getInputStream(), path);

      String imagePath = path.toString();

      // 메뉴 객체 생성 및 설정
      DiningMenu diningMenu = new DiningMenu();
      diningMenu.setMenuName(menuName);
      diningMenu.setBrand(brand);
      diningMenu.setCategory(category);
      diningMenu.setImage(imagePath);
      diningMenu.setWeight(weight);
      diningMenu.setCalories(calories);
      diningMenu.setProtein(protein);
      diningMenu.setSodium(sodium);
      diningMenu.setSugar(sugar);
      diningMenu.setSaturatedFat(saturatedFat);
      diningMenu.setAllergy(allergy);
      diningMenu.setOrigin(origin);

      // 메뉴 정보 데이터베이스에 저장
      diningMenuService.addMenu(diningMenu);

    } catch (IOException e) {
      e.printStackTrace();
      // 파일 처리 오류 처리
      return "/admin/menuadd"; // 오류 페이지 리디렉션
    }

    return "/admin/menuinfo"; // 성공 페이지 리디렉션
  }

  @GetMapping("/admin/menuinfo")
  public String getMenuInfo(Model model) {
    model.addAttribute("menus", diningMenuService.getAllMenus());
    return "/admin/menuinfo";
  }

  @PostMapping("/admin/editMenu")
  public String editMenu(@RequestParam("id") Long id, @RequestParam("menuName") String menuName,
      @RequestParam("brand") String brand, @RequestParam("category") String category,
      @RequestParam("image") String image, @RequestParam("weight") String weight,
      @RequestParam("calories") String calories, @RequestParam("protein") String protein,
      @RequestParam("sodium") String sodium, @RequestParam("sugar") String sugar,
      @RequestParam("saturatedFat") String saturatedFat, @RequestParam("allergy") String allergy,
      @RequestParam("origin") String origin) {
    DiningMenu diningMenu = new DiningMenu(id, menuName, brand, category, image, weight, calories,
        protein, sodium, sugar, saturatedFat, allergy, origin);
    diningMenuService.editMenu(diningMenu);
    return "/admin/menuinfo";
  }

  @GetMapping("/admin/editMenuForm")
  public String editMenuForm(@RequestParam("menuId") Long menuId, Model model) {
    Optional<DiningMenu> diningMenu = diningMenuService.getMenuById(menuId);
    model.addAttribute("diningMenu", diningMenu);
    return "editMenuForm";
  }


  @PostMapping("/admin/deleteMenu")
  public String deleteMenu(@RequestParam("menuId") Long menuId) {
    diningMenuService.deleteMenu(menuId);
    return "redirect:/admin/menuinfo";
  }
}

