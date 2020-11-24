package com.weijiew.lms.controller;

import com.weijiew.lms.dao.BRDao;
import com.weijiew.lms.dao.BookDao;
import com.weijiew.lms.dao.ReaderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * @Description
 * @ClassName DashController
 * @Author jie wei
 * @date 2020.11.18 00:56
 */
@Controller
public class DashController {

    @Autowired
    private ReaderDao readerDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BRDao bRdao;

    @RequestMapping("/infoo")
    public String getInfo(Model model) {
        HashMap borrowedBooksMap = bRdao.getBorrowBookList(readerDao.RNO);
        model.addAttribute("borrowedBooks", borrowedBooksMap.values());
        return "borrowed/tables";
    }

    @GetMapping("/returnBook{BID}")
    public String returnBook(@PathVariable("BID")Integer BID) {
        bRdao.deleteBRDAO(BID);
        return "redirect:/infoo";
    }
}
