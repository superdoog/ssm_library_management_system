package com.lv.controller;

import com.lv.pojo.BookInfo;
import com.lv.service.BookServiceImpl;
import com.lv.utils.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author lv
 */

@Controller
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookServiceImpl bookService;


    @RequestMapping("/bookManager")
    public ModelAndView BooManagement(
            ModelAndView mv,
            @RequestParam(value = "bookName", required = false) String bookName,
            @RequestParam(value = "pageIndex", required = false) String pageIndex){

        //页面显示用户数量
        int pageSize = 6;
        //获取用户总数
        int totalCount = bookService.getCount();
        //当前页面
        int currentPageNo = 1;
        //总页数
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        int totalPageCount = pageSupport.getTotalPageCount();

        if (bookName == null) {
            bookName = "";
        }
        if (pageIndex != null) {
            try {
                currentPageNo = Integer.valueOf(pageIndex);
            } catch (NumberFormatException e) {
                mv.setViewName("redirect:/error.jsp");
                return mv;
            }
        }
        // 控制首页和尾页在范围内
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }

        List<BookInfo> bookList = bookService.getBookList(bookName, currentPageNo, pageSize);
        mv.addObject("booklist", bookList);
        mv.addObject("bookName", bookName);
        mv.addObject("totalPageCount", totalPageCount);
        mv.addObject("totalCount", totalCount);
        mv.addObject("currentPageNo", currentPageNo);

        mv.setViewName("bookManagement");
        return mv;
    }
}
