package com.weijiew.lms.controller;

import com.weijiew.lms.dao.ReaderDao;
import com.weijiew.lms.pojo.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * @Description
 * @ClassName UserController
 * @Author jie wei
 * @Date 2020.11.14 22:43
 */
@Controller
public class ReaderController {

    @Autowired
    private ReaderDao readerDao;

    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping("/emps")
    public String list(Model model) {
        HashMap users = readerDao.getAllUsers();
        model.addAttribute("readers", users.values());
        return "users/tables";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model) {
        HashMap users = readerDao.getAllUsers();
        model.addAttribute("readers", users.values());
        return "users/addUser";
    }

    @PostMapping("/emp")
    public String addUser(Reader reader) {
        readerDao.save(reader);
        return "redirect:/emps";
    }

    @GetMapping("/update{RNO}")
    public String toUpdateUser(@PathVariable("RNO")Integer rno, Model model) {
        Reader users = readerDao.getUserByRNO(rno);
        model.addAttribute("update_users",users);
        return "users/update";
    }

    @PostMapping("/updateUser")
    public String toUpdateSaveUser(Reader reader) {
        readerDao.save(reader);
        return "redirect:/emps";
    }

    @GetMapping("/del{RNO}")
    public String delUser(@PathVariable("RNO")int RNO) {
        readerDao.deleteUserById(RNO);
        return "redirect:/emps";
    }
}
