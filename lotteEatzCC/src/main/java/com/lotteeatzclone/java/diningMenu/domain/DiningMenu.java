package com.lotteeatzclone.java.diningMenu.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "menu_Table")
@Getter
@Setter
@NoArgsConstructor
public class DiningMenu {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "menuName", nullable = false, length = 200)
  private String menuName;

  @Column(name = "brand", nullable = false, length = 20)
  private String brand;

  @Column(name = "category", nullable = false, length = 20)
  private String category;

  @Column(name = "image", nullable = false, length = 200)
  private String image;

  @Column(name = "weight")
  private Integer weight;

  @Column(name = "calories")
  private Integer calories;

  @Column(name = "protein")
  private Integer protein;

  @Column(name = "sodium")
  private Integer sodium;

  @Column(name = "sugar")
  private Integer sugar;

  @Column(name = "saturatedFat")
  private Integer saturatedFat;

  @Column(name = "allergy", length = 200)
  private String allergy;

  @Column(name = "origin", length = 200)
  private String origin;

  // 생성자, 게터, 세터 등은 롬복 어노테이션으로 대체 가능
}
