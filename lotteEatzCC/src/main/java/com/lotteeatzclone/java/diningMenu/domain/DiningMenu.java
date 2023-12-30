package com.lotteeatzclone.java.diningMenu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiningMenu {
  private Integer id;

  @NonNull
  private String menuName;

  @NonNull
  private String brand;

  @NonNull
  private String category;

  @NonNull
  private String image;

  private String weight;
  private String calories;
  private String protein;
  private String sodium;
  private String sugar;
  private String saturatedFat;
  private String allergy;
  private String origin;
  private String price;
  private String mainMenu;
  private String hotMenu;

  public DiningMenu(DiningMenu other) {
    this.id = null; // 새 객체는 새 ID를 가져야 합니다.
    this.menuName = other.menuName;
    this.brand = other.brand;
    this.category = other.category;
    this.image = other.image;
    this.weight = other.weight;
    this.calories = other.calories;
    this.protein = other.protein;
    this.sodium = other.sodium;
    this.sugar = other.sugar;
    this.saturatedFat = other.saturatedFat;
    this.allergy = other.allergy;
    this.origin = other.origin;
    this.price = other.price;
    this.mainMenu = other.mainMenu;
    this.hotMenu = other.hotMenu;
  }
}
