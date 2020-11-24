package com.weijiew.lms.dao;

import com.weijiew.lms.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @ClassName BookDao
 * @Author jie wei
 * @date 2020.11.17 23:28
 */
@Repository
public class BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ReaderDao readerDao;
    private Book book = new Book();

    private static HashMap<Integer,Book> books = new HashMap<Integer, Book>();

    public HashMap<Integer,Book> getAllBooks() {
        String sql = "select * from Book";
        List<Map<String,Object>> list_maps = jdbcTemplate.queryForList(sql);
        for (int i = 0; i < list_maps.size(); i++) {
            Book book = new Book();
            book.setBID(Integer.valueOf((Integer) list_maps.get(i).get("BID")));
            book.setBNO((String) list_maps.get(i).get("BNO"));
            book.setBNAME((String) list_maps.get(i).get("BNAME"));
            book.setBAUTHOR((String) list_maps.get(i).get("BAUTHOR"));
            book.setBPUB((String)list_maps.get(i).get("BPUB"));
            book.setBPRICE(Double.valueOf((Double) list_maps.get(i).get("BPRICE")));
            books.put(i,book);
        }
        return books;
    }

    public void deleteBook(int bid) {
        String sql = "delete from Book where BID=?";
        jdbcTemplate.update(sql,bid);
    }
}
