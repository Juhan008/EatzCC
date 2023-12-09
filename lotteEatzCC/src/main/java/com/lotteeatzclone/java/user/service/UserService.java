package com.lotteeatzclone.java.user.service;

import java.security.MessageDigest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lotteeatzclone.java.user.dao.UserRepository;
import com.lotteeatzclone.java.user.domain.User;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public void add(User user) {
    user.setPassword(cryptoPassword(user.getPassword()));
    userRepository.save(user);
  }

  public User login(String userId, String password) {
    User tempUser = userRepository.findByUserId(userId);

    if (tempUser != null && tempUser.getPassword().equals(cryptoPassword(password))) {
      return tempUser;
    }
    return null;
  }

  private String cryptoPassword(String password) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(password.getBytes());
      byte[] sha256Hash = md.digest();
      StringBuilder sb = new StringBuilder();
      for (byte b : sha256Hash) {
        sb.append(String.format("%02x", b));
      }
      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
