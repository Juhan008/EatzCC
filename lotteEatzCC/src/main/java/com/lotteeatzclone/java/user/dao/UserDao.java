package com.lotteeatzclone.java.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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
      return new User(rs.getInt("id"), rs.getString("userId"), rs.getString("userPassword"),
          rs.getString("name"), rs.getString("phone"), rs.getDate("birth"),
          rs.getTimestamp("createdAt"), rs.getString("member"));
    }
  };

  public void add(User user) {
    jdbcTemplate.update(
        "INSERT INTO users_table (userId, userPassword, name, phone, birth, member) VALUES (?, ?, ?, ?, ?, ?)",
        user.getUserId(), user.getUserPassword(), user.getName(), user.getPhone(), user.getBirth(),
        user.getMember());
  }

  public User get(String userId) {
    return jdbcTemplate.queryForObject("SELECT * FROM users_table WHERE userId = ?", mapper,
        userId);
  }
}
