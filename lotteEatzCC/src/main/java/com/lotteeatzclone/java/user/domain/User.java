package com.lotteeatzclone.java.user.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
@Table(name = "users_Table")
@Getter
@Setter
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false, length = 30)
  private String name;

  @Column(name = "phone", nullable = false, length = 50)
  private String phone;

  @Column(name = "userId", nullable = false, length = 20)
  private String userId;

  @Column(name = "password", nullable = false, length = 30)
  private String password;

  @Column(name = "birth", nullable = false)
  private LocalDate birth;

  @Column(name = "createdAt", columnDefinition = "TIMESTAMP DEFAULT SYSDATE")
  private LocalDateTime createdAt;

  @Column(name = "member", length = 20)
  private String member;

  public User(Long id, String name, String phone, String userId, String password, LocalDate birth,
      LocalDateTime createdAt) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.userId = userId;
    this.password = password;
    this.birth = birth;
    this.createdAt = createdAt;
    this.member = member;
  }
}
