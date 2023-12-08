package com.lotteeatzclone.java.user.domain;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
  private int id;
  @NonNull
  private String name;
  @NonNull
  private String phone;
  @NonNull
  private String userId;
  @NonNull
  private String password;
  private Date birth;
  private Timestamp createdAt;
}
