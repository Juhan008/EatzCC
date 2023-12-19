package com.lotteeatzclone.java.diningMenu.service;


import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
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
    // 먼저 메뉴 항목의 이미지 파일 경로를 조회
    String imagePathQuery = "SELECT \"image\" FROM menu_table WHERE \"id\" = ?";

    // RowMapper를 정의하여 결과를 String으로 매핑
    RowMapper<String> rowMapper = new SingleColumnRowMapper<>(String.class);

    Map<String, Object> resultMap = jdbcTemplate.queryForMap(imagePathQuery, id);
    String imagePath = (String) resultMap.get("imagePath"); // 결과에서 필요한 열을 추출


    if (imagePath != null && !imagePath.isEmpty()) {
      // 파일 시스템에서 이미지 파일 삭제
      try {
        Path path = Paths.get(imagePath);
        Files.deleteIfExists(path);
      } catch (IOException e) {
        e.printStackTrace();
        // 이미지 파일 삭제 오류 처리
      }
    }

    // 데이터베이스에서 메뉴 항목 삭제
    String sql = "DELETE FROM menu_table WHERE \"id\" = ?";
    jdbcTemplate.update(sql, id);
  }


  public void editMenu(DiningMenu diningMenu) {
    String sql =
        "UPDATE menu_table SET \"menuName\" = ?, \"brand\" = ?, \"category\" = ?, \"image\" = ?, \"weight\" = ?, \"calories\" = ?, \"protein\" = ?, \"sodium\" = ?, \"sugar\" = ?, \"saturatedFat\" = ?, \"allergy\" = ?, \"origin\" = ? \"price\" = ? \"mainMenu\" = ? \"hotMenu\" = ? WHERE \"id\" = ?";
    jdbcTemplate.update(sql, diningMenu.getMenuName(), diningMenu.getBrand(),
        diningMenu.getCategory(), diningMenu.getImage(), diningMenu.getWeight(),
        diningMenu.getCalories(), diningMenu.getProtein(), diningMenu.getSodium(),
        diningMenu.getSugar(), diningMenu.getSaturatedFat(), diningMenu.getAllergy(),
        diningMenu.getOrigin(), diningMenu.getPrice(), diningMenu.getMainMenu(),
        diningMenu.getHotMenu(), diningMenu.getId());
  }

  public Optional<DiningMenu> getMenuById(Long id) {
    String sql = "SELECT * FROM menu_table WHERE \"id\" = ?";

    List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, id);

    if (rows.isEmpty()) {
      return Optional.empty();
    } else {
      Map<String, Object> row = rows.get(0);
      DiningMenu diningMenu = new DiningMenu();
      diningMenu.setId(((BigDecimal) row.get("id")).longValue());
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
}

