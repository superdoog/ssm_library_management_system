package com.lv.controller;

import com.alibaba.fastjson.JSONArray;
import com.lv.pojo.LendList;
import com.lv.service.LendListServiceImpl;
import com.lv.utils.PageSupport;
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
public class LendListController {
    @Autowired
    @Qualifier("lendListServiceImpl")
    private LendListServiceImpl lendListService;

    @RequestMapping("/toLendList")
    public ModelAndView toLendList(
            ModelAndView mv,
            @RequestParam(value = "reader_id", required = false) String reader_id,
            @RequestParam(value = "pageIndex", required = false) String pageIndex) {
        int id = 0;
        if (!StringUtils.isNullOrEmpty(reader_id)){
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

    @ResponseBody
    @RequestMapping("/deleteLend")
    public String deleteLendRecord(@RequestParam("ser_num") String ser_num){
        int flag;
        Map<String, String> resultMap = new HashMap<>();
        flag = lendListService.deleteBySer_num(Integer.parseInt(ser_num));
        if (StringUtils.isNullOrEmpty(ser_num)) {
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
