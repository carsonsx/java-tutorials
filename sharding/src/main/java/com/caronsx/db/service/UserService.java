package com.caronsx.db.service;

import com.caronsx.db.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
 * Created by yaoshuangxi on 27/02/2017.
 */
@Service
public class UserService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> list() {
        String sql = "SELECT ID,NAME FROM t_user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User u = new User();
            u.setId(rs.getLong("id"));
            u.setName(rs.getString("name"));
            return u;
        });
    }

    public void add() {
        long id = System.currentTimeMillis();
        String sql = "INSERT INTO `sharding`.`t_user`(`id`,`name`) VALUES(" + id + ",\"" + id + "\")";
        System.out.println(sql);
        jdbcTemplate.execute(sql);

    }
}
