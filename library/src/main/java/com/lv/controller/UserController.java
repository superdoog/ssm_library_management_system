package com.lv.controller;

import com.lv.pojo.Admin;
import com.lv.pojo.ReaderInfo;
import com.lv.service.AdminService;
import com.lv.service.ReaderService;
import com.lv.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author lv
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminService adminService;
    @Autowired
    @Qualifier("ReaderServiceImpl")
    private ReaderService readerService;

    @RequestMapping("/adminLogin")
    public ModelAndView adminLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession Session,ModelAndView mv){
        Admin admin = adminService.login(username);
        if (admin!=null){
            if (admin.getPassword().equals(password)){
                Session.setAttribute(Constants.USER_SESSION, admin);
                mv.setViewName("forward:/bookManager");
                return mv;
            }else {
               mv.addObject("error","密码错误");
            }
        }else {
            mv.addObject("error","用户不存在");
        }
        mv.setViewName("redirect:/adminLogin.jsp");
        return mv;
    }
    @RequestMapping("/readerLogin")
    public ModelAndView readerLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession Session,ModelAndView mv){
        ReaderInfo reader = readerService.login(username);
        if (reader!=null){
            if (reader.getPassword().equals(password)){
                Session.setAttribute(Constants.USER_SESSION, reader);
                mv.setViewName("forward:/bookSelector");
                return mv;
            }else {
               mv.addObject("error","密码错误");
            }
        }else {
            mv.addObject("error","用户不存在");
        }
        mv.setViewName("redirect:/readerLogin.jsp");
        return mv;
    }


    @RequestMapping("/exit")
    public ModelAndView logout(HttpSession session){
        session.removeAttribute(Constants.USER_SESSION);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/readerLogin.jsp");
        return mv;
    }

}
