package com.weijiew.lms.dao;

import com.weijiew.lms.pojo.Book;
import com.weijiew.lms.pojo.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 从书籍表中提取数据
 * @ClassName UserDao
 * @Author jie wei
 * @date 2020.11.13 20:31
 */
@Repository
public class ReaderDao {

    public static int RNO;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Reader reader = new Reader();

    private static HashMap<Integer,Reader> readers = new HashMap<Integer, Reader>();
    private static HashMap<Integer,Book> books = new HashMap<Integer, Book>();

    public HashMap<Integer,Reader> getAllUsers() {
        String sql = "select * from Reader";
        List<Map<String,Object>> list_maps = jdbcTemplate.queryForList(sql);
        for (int i = 0; i < list_maps.size(); i++) {
//            https://blog.csdn.net/hyy_blue/article/details/93313754
            Reader reader = new Reader();
            reader.setRNO(Integer.valueOf((Integer) list_maps.get(i).get("RNO")));
            reader.setRNAME((String) list_maps.get(i).get("RNAME"));
            reader.setPassword((String) list_maps.get(i).get("password"));
            reader.setSuperUser(Integer.valueOf((Integer) list_maps.get(i).get("superUser")));
            reader.setRSEX((String) list_maps.get(i).get("RSEX"));
            reader.setRTEL((String) list_maps.get(i).get("RTEL"));
            reader.setRDEP((String) list_maps.get(i).get("RDEP"));
            readers.put(i,reader);
        }
        return readers;
    }

    public Boolean isValidUser(String username,String password) {
        String sql = "select * from Reader";
        List<Map<String,Object>> list_maps = jdbcTemplate.queryForList(sql);

        for (int i = 0; i < list_maps.size(); i++) {
            Reader reader = new Reader();
            String a =  (String) list_maps.get(i).get("RNAME");
            String b = (String) list_maps.get(i).get("password");
            Integer c = (Integer) list_maps.get(i).get("rno");
            if (a.equals(username) && b.equals(password)) {
                this.RNO = c;
                // 标记当前用用户的 RNO ，后续的借阅查询都是基于此
                return true;
            }
        }
        return false;
    }

    public void save(Reader reader) {
        String sql = "INSERT INTO Reader (RNO,RNAME,password,superUser,RSEX,RTEL) VALUES (?,?,?,?,?,?)";
        Object[] objects = new Object[6];
        objects[0] = reader.getRNO();
        objects[1] = reader.getRNAME();
        objects[2] = reader.getPassword();
        objects[3] = reader.getSuperUser();
        objects[4] = reader.getRSEX();
        objects[5] = reader.getRTEL();
        jdbcTemplate.update(sql,objects);
    }

    public Reader getUserByRNO(int rno) {
        String sql = "select * from Reader where rno="+rno;
        List<Map<String,Object>> list_maps = jdbcTemplate.queryForList(sql);

        Reader reader = new Reader();
        reader.setRNO(Integer.valueOf((Integer) list_maps.get(0).get("RNO")));
        reader.setRNAME((String) list_maps.get(0).get("RNAME"));
        reader.setPassword((String) list_maps.get(0).get("password"));
        reader.setSuperUser(Integer.valueOf((Integer) list_maps.get(0).get("superUser")));
        reader.setRSEX((String) list_maps.get(0).get("RSEX"));
        reader.setRTEL((String) list_maps.get(0).get("RTEL"));
        reader.setRDEP((String) list_maps.get(0).get("RDEP"));
        return reader;
    }

    public void deleteUserById(int rno) {
        String sql = "delete from Reader where rno=?";
        jdbcTemplate.update(sql,rno);
    }
}
