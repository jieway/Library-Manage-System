package com.weijiew.lms.controller;

import com.weijiew.lms.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description JDBC CRUD 练习
 * @ClassName JDBCController
 * @Author jie wei
 * @date 2020.11.15 20:13
 */


@Controller
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/userlist")
    public String userList() {
        String sql = "INSERT INTO Reader (RNO,RNAME,password,superUser,RSEX,RTEL) VALUES (?,?,?,?,?,?)";
        Object[] objects = new Object[6];
        objects[0] = 2073;
        objects[1] = "weijiew";
        objects[2] = "123456";
        objects[3] = 0;
        objects[4] = "男";
        objects[5] = "66573249";
        jdbcTemplate.update(sql,objects);
        return "yes";
    }
    private static HashMap<Integer,Book> books = new HashMap<Integer, Book>();
    @GetMapping("/ssss{id}")
    public String getBorrowBookList(@PathVariable("id")int RNO) {
        String sql = "select * from Book where bno in ( select bno from BR where rno=?)";
        List<Map<String, Object>> allBooks = jdbcTemplate.queryForList(sql,RNO);

        for (int i = 0; i < allBooks.size(); i++) {
            Book book = new Book();
            book.setBNO((String) allBooks.get(i).get("bno"));
            book.setBNAME((String) allBooks.get(i).get("bname"));
            book.setBAUTHOR((String) allBooks.get(i).get("BAUTHOR"));
            book.setBPUB((String) allBooks.get(i).get("BPUB"));
            book.setBPRICE(Double.valueOf((Double) allBooks.get(i).get("BPRICE")));
            books.put(i,book);
        }
        return books.values().toString();
    }

}
