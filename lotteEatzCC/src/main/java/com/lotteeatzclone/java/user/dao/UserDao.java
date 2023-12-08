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
      // TODO Auto-generated method stub
      return new User(rs.getInt("id"), rs.getString("name"), rs.getString("phone"),
          rs.getString("userId"), rs.getString("password"), rs.getDate("birth"),
          rs.getTimestamp("createdAt"));
    }
  };

  public void add(User user) {
    jdbcTemplate.update(
        "insert into users (\"name\", \"phone\", \"userId\", \"password\", \"birth\", \"createdAt\") values (?, ?, ?, ?, ?, ?, ?, ?)",
        user.getUserId(), user.getPassword(), user.getName(), user.getPhone(), user.getBirth());
  }

  public User get(String userId) {
    return jdbcTemplate.queryForObject("select * from users where \"userId\"=?", mapper, userId);
  }
}

