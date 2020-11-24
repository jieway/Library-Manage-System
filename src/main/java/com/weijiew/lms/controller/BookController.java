package com.weijiew.lms.controller;

import com.weijiew.lms.dao.BRDao;
import com.weijiew.lms.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * @Description 现实全部书籍
 * @ClassName BookController
 * @Author jie wei
 * @date 2020.11.17 23:49
 */

@Controller
public class BookController {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private BRDao bRDao;

    @RequestMapping("/books")
    public String getAllBooks(Model model) {
        HashMap bookMap = bookDao.getAllBooks();
        model.addAttribute("books",bookMap.values());
        return "book/book";
    }

    @RequestMapping("/borrow{BID}")
    public String borrowBook(@PathVariable("BID")Integer BID) {
        bRDao.borrowedBooks(BID);
        return "redirect:/allbooks";
    }

    @GetMapping("/delbook{BID}")
    public String delbook(@PathVariable("BID")Integer BID) {
        bookDao.deleteBook(BID);
        return "redirect:/allbooks";
    }
}
