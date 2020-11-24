package com.weijiew.lms.dao;

import com.weijiew.lms.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 借阅表对应的数据访问层
 * @ClassName BRDao
 * @Author jie wei
 * @Date 2020.11.20 20:07
 */
@Repository
public class BRDao {

    @Autowired
    private ReaderDao readerDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static HashMap<Integer,Book> books = new HashMap<Integer, Book>();
    public void borrowedBooks(Integer bid) {
        String sql = "INSERT INTO BR (BID,RNO) VALUES (?,?)";
//        Date time= new java.sql.Date(new java.util.Date().getTime());
        Object[] objects = new Object[2];
        objects[0] = bid;
        objects[1] = readerDao.RNO;
        jdbcTemplate.update(sql,objects);
    }

    public void deleteBRDAO(int bid) {
        String sql = "delete from BR where BID=?";
        jdbcTemplate.update(sql,bid);
    }

    // 根据读者号查询所借书籍信息
    public HashMap getBorrowBookList(int RNO) {
        String sql = "select * from Book where bid in (select bid from BR where rno=?)";
        List<Map<String, Object>> allBooks = jdbcTemplate.queryForList(sql,RNO);
        for (int i = 0; i < allBooks.size(); i++) {
            Book book = new Book();
            book.setBID(Integer.valueOf((Integer) allBooks.get(i).get("bid")));
            book.setBNO((String) allBooks.get(i).get("bno"));
            book.setBNAME((String) allBooks.get(i).get("bname"));
            book.setBAUTHOR((String) allBooks.get(i).get("BAUTHOR"));
            book.setBPUB((String) allBooks.get(i).get("BPUB"));
            book.setBPRICE(Double.valueOf((Double) allBooks.get(i).get("BPRICE")));
            books.put(i, book);
        }
        return books;
    }

}
