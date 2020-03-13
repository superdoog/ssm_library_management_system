package com.lv.controller;

import com.alibaba.fastjson.JSONArray;
import com.lv.pojo.BookInfo;
import com.lv.service.BookServiceImpl;
import com.lv.utils.PageSupport;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lv
 */

@Controller
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookServiceImpl bookService;


    @RequestMapping("/bookManager")
    public ModelAndView BookManagement(
            ModelAndView mv,
            @RequestParam(value = "bookName", required = false) String bookName,
            @RequestParam(value = "pageIndex", required = false) String pageIndex){

        //页面显示书籍数量
        int pageSize = 6;
        //获取用户总数
        int totalCount = bookService.getCount(bookName);
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

    @RequestMapping("/bookAddPage")
    public String toBookAddPage(){
        return "bookAdd";
    }
    @RequestMapping("/addBook")
    public ModelAndView addBook(ModelAndView mv, @RequestParam("book_id") String book_id,
                                @RequestParam("book_name") String book_name,
                                @RequestParam("author") String author,
                                @RequestParam("total") String total,
                                @RequestParam("number") String number){

        int flag;
        BookInfo book = new BookInfo(Integer.parseInt(book_id),
                book_name,
                author,
                Integer.parseInt(total),
                Integer.parseInt(number));

       flag =  bookService.addBook(book);
       if (flag == 0){
           mv.addObject("error", "增加书籍失败");
           mv.setViewName("../error");
           return mv;
       }
       mv.setViewName("redirect:/bookManager");
       return mv;
    }


    @RequestMapping("/bookView")
    public ModelAndView toBookView(ModelAndView mv, @RequestParam("book_id") String book_id){
        BookInfo book = bookService.getBookById(Integer.parseInt(book_id));
        mv.addObject("book",book);
        mv.setViewName("bookView");
        return mv;
    }


    @RequestMapping("/bookModifyPage")
    public ModelAndView toBookModifyPage(ModelAndView mv, @RequestParam("book_id") String book_id){
        BookInfo book = bookService.getBookById(Integer.parseInt(book_id));
        mv.addObject("book",book);
        mv.setViewName("bookModify");
        return mv;
    }
    @RequestMapping("/updateBook")
    public ModelAndView updateBook(ModelAndView mv, @RequestParam("book_id") String book_id,
                                   @RequestParam("book_name") String book_name,
                                   @RequestParam("author") String author,
                                   @RequestParam("total") String total,
                                   @RequestParam("number") String number){
        int flag;
        BookInfo book = new BookInfo(Integer.parseInt(book_id),
                book_name,
                author,
                Integer.parseInt(total),
                Integer.parseInt(number));

        flag =  bookService.updateBook(book);
        if (flag == 0){
            mv.addObject("error", "修改书籍失败");
            mv.setViewName("../error");
            return mv;
        }
        mv.setViewName("redirect:/bookManager");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam("book_id") String book_id){
       int flag;
        Map<String, String> resultMap = new HashMap<>();
        flag = bookService.deleteBook(Integer.parseInt(book_id));
        if (StringUtils.isNullOrEmpty(book_id)) {
            //不存在
            resultMap.put("delResult", "notexist");
        } else {
            if (flag == 1) {
                //删除成功
                resultMap.put("delResult", "true");
            } else {
                //删除失败
                resultMap.put("delResult", "false");
            }
        }
        return JSONArray.toJSONString(resultMap);
    }
    }



