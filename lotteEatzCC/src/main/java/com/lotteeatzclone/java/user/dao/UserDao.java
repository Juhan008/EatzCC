package com.lotteeatzclone.java.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.lotteeatzclone.java.user.domain.User;

@Repository
public class UserDao {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  private RowMapper<User> mapper = new RowMapper<User>() {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      Long id = rs.getLong("id");
      String name = rs.getString("name");
      String phone = rs.getString("phone");
      String userId = rs.getString("userId");
      String password = rs.getString("password");
      LocalDate birth = rs.getDate("birth") != null ? rs.getDate("birth").toLocalDate() : null;
      LocalDateTime createdAt =
          rs.getTimestamp("createdAt") != null ? rs.getTimestamp("createdAt").toLocalDateTime()
              : null;

      return new User(id, name, phone, userId, password, birth, createdAt);
    }
  };
}

