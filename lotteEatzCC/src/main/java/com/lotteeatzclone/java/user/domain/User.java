package com.lotteeatzclone.java.user.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private Long id;
  @NonNull
  private String userId;
  @NonNull
  private String userPassword;
  @NonNull
  private String name;
  @NonNull
  private String phone;
  private Date birth;
  private Date createdAt;
  private String member;
}


