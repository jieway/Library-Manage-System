package com.weijiew.lms.controller;

import com.weijiew.lms.dao.ReaderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @Description 登陆以及拦截功能的实现
 * @ClassName LoginController
 * @Author jie wei
 * @date 2020.11.14 17:47
 */
@Controller
public class LoginController {

    @Autowired
    private ReaderDao readerDao;
    public static int RNO ;

    @RequestMapping("/user/login")
    public String login(
        @RequestParam("username") String username,
        @RequestParam("password") String password,
        Model model,
        HttpSession session) {

        Boolean isValid = readerDao.isValidUser(username, password);

        if (isValid) {
            session.setAttribute("loginUser",username);

            return "redirect:/dashboard.html";
        }else {
            model.addAttribute("msg","用户名或密码错误");
            return "redirect:/index.html";
        }
    }
}
