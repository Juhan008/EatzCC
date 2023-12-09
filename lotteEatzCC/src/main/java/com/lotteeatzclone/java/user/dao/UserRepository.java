package com.lotteeatzclone.java.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lotteeatzclone.java.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByUserId(String userId);
}
