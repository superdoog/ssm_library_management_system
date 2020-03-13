package com.lv.controller;

import com.alibaba.fastjson.JSONArray;
import com.lv.pojo.ReaderInfo;
import com.lv.service.ReaderServiceImpl;
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
public class ReaderController {

    @Autowired
    @Qualifier("readerServiceImpl")
    private ReaderServiceImpl readerService;

    @RequestMapping("/readerList")
    public ModelAndView BooManagement(
            ModelAndView mv,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "pageIndex", required = false) String pageIndex) {

        //页面显示用户数量
        int pageSize = 6;
        //获取用户总数
        int totalCount = readerService.getCount(username);
        //当前页面
        int currentPageNo = 1;
        //总页数
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        int totalPageCount = pageSupport.getTotalPageCount();

        if (username == null) {
            username = "";
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

        List<ReaderInfo> readerlist = readerService.getReaderList(username, currentPageNo, pageSize);
        mv.addObject("readerlist", readerlist);
        mv.addObject("username", username);
        mv.addObject("totalPageCount", totalPageCount);
        mv.addObject("totalCount", totalCount);
        mv.addObject("currentPageNo", currentPageNo);

        mv.setViewName("readerList");
        return mv;
    }

    @RequestMapping("/readerAddPage")
    public String toReaderAddPage() {
        return "readerAdd";
    }

    @RequestMapping("/addReader")
    public ModelAndView addReader(ModelAndView mv, @RequestParam("reader_id") String reader_id,
                                  @RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  @RequestParam("name") String name) {
        int flag;
        ReaderInfo reader = new ReaderInfo(Integer.parseInt(reader_id), username, password, name);

        flag = readerService.addReader(reader);
        if (flag == 0) {
            mv.addObject("error", "增加读者失败");
            mv.setViewName("../error");
            return mv;
        }
        mv.setViewName("redirect:/readerList");
        return mv;
    }

    @RequestMapping("/readerModifyPage")
    public ModelAndView toReaderModifyPage(ModelAndView mv, @RequestParam("reader_id") String reader_id) {
        ReaderInfo reader = readerService.getReaderById(Integer.parseInt(reader_id));
        mv.addObject("reader", reader);
        mv.setViewName("readerModify");
        return mv;
    }

    @RequestMapping("/updateReader")
    public ModelAndView updateReader(ModelAndView mv, @RequestParam("reader_id") String reader_id,
                                     @RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     @RequestParam("name") String name) {
        int flag;
        ReaderInfo reader = new ReaderInfo(Integer.parseInt(reader_id), username, password, name);
        flag = readerService.updateReader(reader);
        if (flag == 0) {
            mv.addObject("error", "修改读者失败");
            mv.setViewName("../error");
            return mv;
        }
        mv.setViewName("redirect:/readerList");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/deleteReader")
    public String deleteReader(@RequestParam("reader_id") String reader_id) {
        int flag;
        Map<String, String> resultMap = new HashMap<>();
        flag = readerService.deleteReader(Integer.parseInt(reader_id));
        if (StringUtils.isNullOrEmpty(reader_id)) {
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



