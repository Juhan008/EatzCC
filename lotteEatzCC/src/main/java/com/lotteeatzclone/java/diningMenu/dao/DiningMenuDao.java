package com.lotteeatzclone.java.diningMenu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.lotteeatzclone.java.diningMenu.domain.DiningMenu;

@Repository
public class DiningMenuDao {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public DiningMenuDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void add(DiningMenu diningMenu) {
    String sql =
        "INSERT INTO menu_table (\"menuName\", \"brand\", \"category\", \"image\", \"weight\", \"calories\", \"protein\", \"sodium\", \"sugar\", \"saturatedFat\", \"allergy\", \"origin\", \"price\", \"mainMenu\", \"hotMenu\") "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";

    jdbcTemplate.update(sql, diningMenu.getMenuName(), diningMenu.getBrand(),
        diningMenu.getCategory(), diningMenu.getImage(), diningMenu.getWeight(),
        diningMenu.getCalories(), diningMenu.getProtein(), diningMenu.getSodium(),
        diningMenu.getSugar(), diningMenu.getSaturatedFat(), diningMenu.getAllergy(),
        diningMenu.getOrigin(), diningMenu.getPrice(), diningMenu.getMainMenu(),
        diningMenu.getHotMenu());
  }
}

