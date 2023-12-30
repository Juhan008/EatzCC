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


  @PostMapping("/submitMenu")
  public String submitMenu(@RequestParam("menuName") String menuName,
      @RequestParam("brand") String brand, @RequestParam("category") String category,
      @RequestParam("image") MultipartFile file, @RequestParam("weight") String weight,
      @RequestParam("calories") String calories, @RequestParam("protein") String protein,
      @RequestParam("sodium") String sodium, @RequestParam("sugar") String sugar,
      @RequestParam("saturatedFat") String saturatedFat, @RequestParam("allergy") String allergy,
      @RequestParam("origin") String origin, @RequestParam("price") String price,
      @RequestParam("mainMenu") String mainMenu, @RequestParam("hotMenu") String hotMenu) {
    try {
      // 이미지 파일 처리
      String originName = file.getOriginalFilename();
      String ext = originName.substring(originName.lastIndexOf("."));
      String randomName = UUID.randomUUID().toString() + ext;
      String savePath = "/root/lotteEatzCC/src/main/resources/static/images/menu/" + randomName;
      Path path = Paths.get(savePath);
      Files.copy(file.getInputStream(), path);

      String webImagePath = "/images/menu/" + randomName; // 웹 URL 경로

      // 메뉴 객체 생성 및 설정
      DiningMenu diningMenu = new DiningMenu();
      diningMenu.setMenuName(menuName);
      diningMenu.setBrand(brand);
      diningMenu.setCategory(category);
      diningMenu.setImage(webImagePath);
      diningMenu.setWeight(weight);
      diningMenu.setCalories(calories);
      diningMenu.setProtein(protein);
      diningMenu.setSodium(sodium);
      diningMenu.setSugar(sugar);
      diningMenu.setSaturatedFat(saturatedFat);
      diningMenu.setAllergy(allergy);
      diningMenu.setOrigin(origin);
      diningMenu.setPrice(price);
      diningMenu.setMainMenu(mainMenu);
      diningMenu.setHotMenu(hotMenu);

      // 메뉴 정보 데이터베이스에 저장
      diningMenuService.addMenu(diningMenu);

    } catch (IOException e) {
      e.printStackTrace();
      // 파일 처리 오류 처리
      return "/admin/menuadd"; // 오류 페이지 리디렉션
    }

    return "/admin/menuinfo"; // 성공 페이지 리디렉션
  }



  @PostMapping("/admin/editMenu")
  public String editMenu(@RequestParam("id") Integer id, @RequestParam("menuName") String menuName,
      @RequestParam("brand") String brand, @RequestParam("category") String category,
      @RequestParam("image") String image, @RequestParam("weight") String weight,
      @RequestParam("calories") String calories, @RequestParam("protein") String protein,
      @RequestParam("sodium") String sodium, @RequestParam("sugar") String sugar,
      @RequestParam("saturatedFat") String saturatedFat, @RequestParam("allergy") String allergy,
      @RequestParam("origin") String origin, @RequestParam("price") String price,
      @RequestParam("mainMenu") String mainMenu, @RequestParam("hotMenu") String hotMenu) {
    DiningMenu diningMenu = new DiningMenu(id, menuName, brand, category, image, weight, calories,
        protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu);
    diningMenuService.editMenu(diningMenu);
    return "redirect:/admin/menuinfo";
  }

  @GetMapping("/admin/menuadd")
  public String showRegistrationPage() {
    return "/admin/menuadd";
  }

  @GetMapping("/brand/lotteria")
  public String brandLotteriaPage() {
    return "/brand/lotteria";
  }


  @GetMapping("/admin/menuinfo")
  public String getMenuInfo(Model model) {
    model.addAttribute("menus", diningMenuService.getAllMenus());
    return "/admin/menuinfo";
  }

  @GetMapping("/admin/editMenuForm")
  public String editMenuForm(@RequestParam("id") Long id, Model model) {
    Optional<DiningMenu> diningMenuOpt = diningMenuService.getMenuById(id);
    if (diningMenuOpt.isPresent()) {
      model.addAttribute("menu", diningMenuOpt.get());
      return "admin/editMenuForm";
    } else {
      return "redirect:/errorPage";
    }
  }

  @PostMapping("/admin/deleteMenu")
  public String deleteMenu(@RequestParam("menuId") Long id) {
    diningMenuService.deleteMenu(id);
    return "redirect:/admin/menuinfo";
  }

  @PostMapping("/admin/copyMenu")
  public String copyMenu(@RequestParam("menuId") Long menuId) {
    diningMenuService.copyMenuById(menuId);
    return "redirect:/admin/menuinfo";
  }
}

