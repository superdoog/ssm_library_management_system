package com.lv.controller;

import com.lv.pojo.Admin;
import com.lv.service.AdminServiceImpl;
import com.lv.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author lv
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminServiceImpl adminService;

    @RequestMapping("/reader")
    public String toReaderLogin(){
        return "readerLogin";
    }
    @RequestMapping("/admin")
    public String toAdminLogin(){
        return "adminLogin";
    }

    @RequestMapping("/adminLogin")
    public String adminLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession Session, Model model){
        Admin admin = adminService.login(username);
        if (admin!=null){
            if (admin.getPassword().equals(password)){
                Session.setAttribute(Constants.USER_SESSION, admin);
                return "bookManagement";
            }else {
               model.addAttribute("error","密码错误");
            }
        }else {
            model.addAttribute("error","用户不存在");
        }
        return "adminLogin";
    }
    @RequestMapping("/exit")
    public String logout(HttpSession session){
        session.removeAttribute(Constants.USER_SESSION);
        return "redirect:/user/reader";
    }

}
