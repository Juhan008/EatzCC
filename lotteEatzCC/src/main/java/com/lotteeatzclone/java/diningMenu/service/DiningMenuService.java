package com.lotteeatzclone.java.diningMenu.service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.lotteeatzclone.java.diningMenu.dao.DiningMenuDao;
import com.lotteeatzclone.java.diningMenu.domain.DiningMenu;

@Service
public class DiningMenuService {
  private DiningMenuDao diningMenuDao;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public DiningMenuService(DiningMenuDao diningMenuDao) {
    this.diningMenuDao = diningMenuDao;
  }

  public void addMenu(DiningMenu diningMenu) {
    diningMenuDao.add(diningMenu);
  }

  public List<DiningMenu> getAllMenus() {
    String sql = "SELECT * FROM menu_table";
    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(DiningMenu.class));
  }

  public void deleteMenu(Long id) {
    String imagePathQuery = "SELECT image FROM menu_table WHERE id = ?";


    Map<String, Object> resultMap = jdbcTemplate.queryForMap(imagePathQuery, id);
    String imagePath = (String) resultMap.get("imagePath");


    if (imagePath != null && !imagePath.isEmpty()) {

      try {
        Path path = Paths.get(imagePath);
        Files.deleteIfExists(path);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    String sql = "DELETE FROM menu_table WHERE id = ?";
    jdbcTemplate.update(sql, id);
  }


  public void editMenu(DiningMenu diningMenu) {
    String sql =
        "UPDATE menu_table SET menuName = ?, brand = ?, category = ?, image = ?, weight = ?, calories = ?, protein = ?, sodium = ?, sugar = ?, saturatedFat = ?, allergy = ?, origin = ?, price = ?, mainMenu = ?, hotMenu = ? WHERE id = ?";

    jdbcTemplate.update(sql, diningMenu.getMenuName(), diningMenu.getBrand(),
        diningMenu.getCategory(), diningMenu.getImage(), diningMenu.getWeight(),
        diningMenu.getCalories(), diningMenu.getProtein(), diningMenu.getSodium(),
        diningMenu.getSugar(), diningMenu.getSaturatedFat(), diningMenu.getAllergy(),
        diningMenu.getOrigin(), diningMenu.getPrice(), diningMenu.getMainMenu(),
        diningMenu.getHotMenu(), diningMenu.getId());
  }

  public Optional<DiningMenu> getMenuById(Long id) {
    String sql = "SELECT * FROM menu_table WHERE id = ?";

    List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, id);

    if (rows.isEmpty()) {
      return Optional.empty();
    } else {
      Map<String, Object> row = rows.get(0);
      DiningMenu diningMenu = new DiningMenu();
      diningMenu.setId((Integer) row.get("id"));
      diningMenu.setMenuName((String) row.get("menuName"));
      diningMenu.setBrand((String) row.get("brand"));
      diningMenu.setCategory((String) row.get("category"));
      diningMenu.setImage((String) row.get("image"));
      diningMenu.setWeight((String) row.get("weight"));
      diningMenu.setCalories((String) row.get("calories"));
      diningMenu.setProtein((String) row.get("protein"));
      diningMenu.setSodium((String) row.get("sodium"));
      diningMenu.setSugar((String) row.get("sugar"));
      diningMenu.setSaturatedFat((String) row.get("saturatedFat"));
      diningMenu.setAllergy((String) row.get("allergy"));
      diningMenu.setOrigin((String) row.get("origin"));
      diningMenu.setPrice((String) row.get("price"));
      diningMenu.setMainMenu((String) row.get("mainMenu"));
      diningMenu.setHotMenu((String) row.get("hotMenu"));
      return Optional.of(diningMenu);
    }
  }


  public List<DiningMenu> getMenusByBrandAndMainMenu(String brand, String mainMenu) {
    try {
      List<DiningMenu> menus = diningMenuDao.findByBrandAndMainMenu(brand, mainMenu);
      if (menus.isEmpty()) {
        throw new Exception(
            "No menus found for the brand: " + brand + " and main menu: " + mainMenu);
      }
      return menus;
    } catch (Exception e) {
      // 여기에 로깅 또는 다른 예외 처리 로직을 구현하세요.
      throw new ServiceException("Error occurred while fetching menus", e);
    }
  }

  public List<DiningMenu> findHotMenusByBrand(String brand) {
    return diningMenuDao.findByBrandAndHotMenu(brand, "a");
  }

  public List<DiningMenu> findMenusByCategory(String category) {
    return diningMenuDao.findMenusByCategory(category);
  }

  public void copyMenuById(Long menuId) {
    DiningMenu originalMenu = diningMenuDao.findById(menuId);
    if (originalMenu != null) {
      DiningMenu copiedMenu = new DiningMenu(originalMenu);
      copiedMenu.setId(null);
      diningMenuDao.save(copiedMenu);
    }
  }

  public List<DiningMenu> getHotMenus(String brand, String hotMenu) {
    String sql = "SELECT * FROM menu_table WHERE brand = ? AND hotMenu = ?";

    List<DiningMenu> menus = new ArrayList<>();
    List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, brand, hotMenu);

    for (Map<String, Object> row : rows) {
      DiningMenu diningMenu = new DiningMenu();
      diningMenu.setId((Integer) row.get("id"));
      diningMenu.setMenuName((String) row.get("menuName"));
      diningMenu.setBrand((String) row.get("brand"));
      diningMenu.setCategory((String) row.get("category"));
      diningMenu.setImage((String) row.get("image"));
      diningMenu.setWeight((String) row.get("weight"));
      diningMenu.setCalories((String) row.get("calories"));
      diningMenu.setProtein((String) row.get("protein"));
      diningMenu.setSodium((String) row.get("sodium"));
      diningMenu.setSugar((String) row.get("sugar"));
      diningMenu.setSaturatedFat((String) row.get("saturatedFat"));
      diningMenu.setAllergy((String) row.get("allergy"));
      diningMenu.setOrigin((String) row.get("origin"));
      diningMenu.setPrice((String) row.get("price"));
      diningMenu.setMainMenu((String) row.get("mainMenu"));
      diningMenu.setHotMenu((String) row.get("hotMenu"));
      menus.add(diningMenu);
    }

    return menus;
  }

}

