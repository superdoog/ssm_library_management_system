package com.lv.controller;

import com.alibaba.fastjson.JSONArray;
import com.lv.pojo.BookInfo;
import com.lv.pojo.LendList;
import com.lv.pojo.ReaderInfo;
import com.lv.service.BookServiceImpl;
import com.lv.service.LendListServiceImpl;
import com.lv.utils.Constants;
import com.lv.utils.DateUtil;
import com.lv.utils.PageSupport;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lv
 */
@Controller
public class LendListController {
    @Autowired
    @Qualifier("lendListServiceImpl")
    private LendListServiceImpl lendListService;

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookServiceImpl bookService;

    @RequestMapping("/toLendList")
    public ModelAndView toLendList(
            ModelAndView mv,
            @RequestParam(value = "reader_id", required = false) String reader_id,
            @RequestParam(value = "pageIndex", required = false) String pageIndex) {
        int id = 0;
        if (!StringUtils.isNullOrEmpty(reader_id)) {
            id = Integer.parseInt(reader_id);
        }

        //页面显示用户数量
        int pageSize = 6;
        //获取用户总数
        int totalCount = lendListService.getCount(id);
        //当前页面
        int currentPageNo = 1;
        //总页数
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        int totalPageCount = pageSupport.getTotalPageCount();

        if (pageIndex != null) {
            try {
                currentPageNo = Integer.parseInt(pageIndex);
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

        List<LendList> lendList = lendListService.getLendList(id, currentPageNo, pageSize);

        mv.addObject("lendlist", lendList);
        mv.addObject("reader_id", reader_id);
        mv.addObject("totalPageCount", totalPageCount);
        mv.addObject("totalCount", totalCount);
        mv.addObject("currentPageNo", currentPageNo);

        mv.setViewName("lendList");

        return mv;
    }

    @RequestMapping("/toReaderLendList")
    public ModelAndView toReaderLendList(
            ModelAndView mv,
            @RequestParam(value = "pageIndex", required = false) String pageIndex,
            HttpSession session) {
        ReaderInfo reader = (ReaderInfo) session.getAttribute(Constants.USER_SESSION);
        int id = reader.getReader_id();

        //页面显示用户数量
        int pageSize = 6;
        //获取用户总数
        int totalCount = lendListService.getCount(id);
        //当前页面
        int currentPageNo = 1;
        //总页数
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        int totalPageCount = pageSupport.getTotalPageCount();

        if (pageIndex != null) {
            try {
                currentPageNo = Integer.parseInt(pageIndex);
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

        List<LendList> lendList = lendListService.getLendList(id, currentPageNo, pageSize);

        mv.addObject("lendlist", lendList);
        mv.addObject("totalPageCount", totalPageCount);
        mv.addObject("totalCount", totalCount);
        mv.addObject("currentPageNo", currentPageNo);

        mv.setViewName("readerLendList");

        return mv;
    }

    @ResponseBody
    @RequestMapping("/deleteLend")
    public String deleteLendRecord(@RequestParam("ser_num") String ser_num) {
        int flag;
        LendList lendList = lendListService.getLendListBySer_num(Integer.parseInt(ser_num));
        BookInfo book = bookService.getBookById(lendList.getBook_id());
        int bookNum = book.getNumber();
        Map<String, String> resultMap = new HashMap<>();
        flag = lendListService.deleteBySer_num(Integer.parseInt(ser_num));
        if (StringUtils.isNullOrEmpty(ser_num)) {
            //不存在
            resultMap.put("delResult", "notexist");
        } else {
            if (flag == 1) {
                //删除成功
                book.setNumber(bookNum + 1);
                bookService.updateBook(book);
                resultMap.put("delResult", "true");
            } else {
                //删除失败
                resultMap.put("delResult", "false");
            }
        }
        return JSONArray.toJSONString(resultMap);
    }

    @ResponseBody
    @RequestMapping("/LendBook")
    public String lendBook(@RequestParam("book_id") String book_id, HttpSession session) {
        ReaderInfo reader = (ReaderInfo) session.getAttribute(Constants.USER_SESSION);
        BookInfo book = bookService.getBookById(Integer.parseInt(book_id));
        int bookNum = book.getNumber();
        int flag;

        Date today = new Date();
        Date backDay = DateUtil.addAndSubtractDaysByGetTime(today, 30);

        LendList lendList = new LendList(Integer.parseInt(book_id), reader.getReader_id(), today, backDay);

        Map<String, String> resultMap = new HashMap<>();
        if (bookNum == 0) {
            resultMap.put("Result", "notexist");
        } else {
            flag = lendListService.addLendList(lendList);
            if (flag == 1) {
                book.setNumber(bookNum - 1);
                bookService.updateBook(book);
                resultMap.put("Result", "true");
            } else {
                resultMap.put("Result", "false");
            }
        }
        return JSONArray.toJSONString(resultMap);
    }
}
