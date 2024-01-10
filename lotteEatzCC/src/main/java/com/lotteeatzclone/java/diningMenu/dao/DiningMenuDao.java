package com.lotteeatzclone.java.diningMenu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.lotteeatzclone.java.diningMenu.domain.DiningMenu;

@Repository
public class DiningMenuDao {
  private final JdbcTemplate jdbcTemplate;

  public DiningMenuDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void add(DiningMenu diningMenu) {
    String sql =
        "UPDATE menu_table SET menuName = ?, brand = ?, category = ?, image = ?, weight = ?, calories = ?, protein = ?, sodium = ?, sugar = ?, saturatedFat = ?, allergy = ?, origin = ?, price = ?, mainMenu = ?, hotMenu = ? WHERE id = ?";

    jdbcTemplate.update(sql, diningMenu.getMenuName(), diningMenu.getBrand(),
        diningMenu.getCategory(), diningMenu.getImage(), diningMenu.getWeight(),
        diningMenu.getCalories(), diningMenu.getProtein(), diningMenu.getSodium(),
        diningMenu.getSugar(), diningMenu.getSaturatedFat(), diningMenu.getAllergy(),
        diningMenu.getOrigin(), diningMenu.getPrice(), diningMenu.getMainMenu(),
        diningMenu.getHotMenu());
  }

  public List<DiningMenu> findByBrandAndMainMenu(String brand, String mainMenu) {
    String sql = "SELECT * FROM menu_table WHERE brand = ? AND mainMenu = ?";

    return jdbcTemplate.query(sql, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, brand);
        ps.setString(2, mainMenu);
      }
    }, mapper);
  }

  public List<DiningMenu> findByBrandAndHotMenu(String brand, String hotMenu) {
    String sql = "SELECT * FROM menu_table WHERE brand = ? AND hotMenu = ?";

    return jdbcTemplate.query(sql, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, brand);
        ps.setString(2, hotMenu);
      }
    }, mapper);
  }


  public List<DiningMenu> findMenusByCategory(String category) {
    String sql = "SELECT * FROM menu_table WHERE category = ?";

    return jdbcTemplate.query(sql, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, category);
      }
    }, mapper);
  }


  private RowMapper<DiningMenu> mapper = new RowMapper<DiningMenu>() {
    @Override
    public DiningMenu mapRow(ResultSet rs, int rowNum) throws SQLException {
      DiningMenu diningMenu = new DiningMenu();
      diningMenu.setId((Integer) rs.getInt("id"));
      diningMenu.setMenuName(rs.getString("menuName"));
      diningMenu.setBrand(rs.getString("brand"));
      diningMenu.setCategory(rs.getString("category"));
      diningMenu.setImage(rs.getString("image"));
      diningMenu.setWeight(rs.getString("weight"));
      diningMenu.setCalories(rs.getString("calories"));
      diningMenu.setProtein(rs.getString("protein"));
      diningMenu.setSodium(rs.getString("sodium"));
      diningMenu.setSugar(rs.getString("sugar"));
      diningMenu.setSaturatedFat(rs.getString("saturatedFat"));
      diningMenu.setAllergy(rs.getString("allergy"));
      diningMenu.setOrigin(rs.getString("origin"));
      diningMenu.setPrice(rs.getString("price"));
      diningMenu.setMainMenu(rs.getString("mainMenu"));
      diningMenu.setHotMenu(rs.getString("hotMenu"));
      return diningMenu;
    }
  };

  public DiningMenu findById(Long menuId) {
    String sql = "SELECT * FROM menu_table WHERE id = ?";
    List<DiningMenu> menus = jdbcTemplate.query(sql, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setLong(1, menuId);
      }
    }, mapper);

    return menus.isEmpty() ? null : menus.get(0);
  }


  public void save(DiningMenu diningMenu) {
    String sql =
        "INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    jdbcTemplate.update(sql, diningMenu.getMenuName(), diningMenu.getBrand(),
        diningMenu.getCategory(), diningMenu.getImage(), diningMenu.getWeight(),
        diningMenu.getCalories(), diningMenu.getProtein(), diningMenu.getSodium(),
        diningMenu.getSugar(), diningMenu.getSaturatedFat(), diningMenu.getAllergy(),
        diningMenu.getOrigin(), diningMenu.getPrice(), diningMenu.getMainMenu(),
        diningMenu.getHotMenu());
  }

}

