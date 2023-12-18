package com.lotteeatzclone.java.diningMenu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiningMenu {
  private Long id;

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
}
