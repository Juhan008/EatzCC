package com.lotteeatzclone.java.diningMenu.service;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.lotteeatzclone.java.diningMenu.dao.DiningMenuDao;
import com.lotteeatzclone.java.diningMenu.domain.DiningMenu;

@Service
public class DiningMenuService {
  private final DiningMenuDao diningMenuDao;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
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
    String sql = "DELETE FROM menu_table WHERE id = ?";
    jdbcTemplate.update(sql, id);
  }

  public void editMenu(DiningMenu diningMenu) {
    String sql =
        "UPDATE menu_table SET menu_name = ?, brand = ?, category = ?, image = ?, weight = ?, calories = ?, protein = ?, sodium = ?, sugar = ?, saturatedFat = ?, allergy = ?, origin = ? WHERE id = ?";

    jdbcTemplate.update(sql, diningMenu.getMenuName(), diningMenu.getBrand(),
        diningMenu.getCategory(), diningMenu.getImage(), diningMenu.getWeight(),
        diningMenu.getCalories(), diningMenu.getProtein(), diningMenu.getSodium(),
        diningMenu.getSugar(), diningMenu.getSaturatedFat(), diningMenu.getAllergy(),
        diningMenu.getOrigin(), diningMenu.getId());
  }

  public Optional<DiningMenu> getMenuById(Long id) {
    String sql = "SELECT * FROM menu_table WHERE id = ?";
    List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, id);

    if (rows.isEmpty()) {
      return Optional.empty();
    } else {
      Map<String, Object> row = rows.get(0);
      DiningMenu diningMenu = new DiningMenu();
      diningMenu.setId((Long) row.get("id"));
      diningMenu.setMenuName((String) row.get("menu_name"));
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
      return Optional.of(diningMenu);
    }
  }
}

