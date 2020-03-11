package com.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lv
 */
@Controller
public class PageController {

//    @RequestMapping("/bookM")
//    public String toBookManagement(){
//        return "forward:/bookManager";
//    }

    @RequestMapping("/lendList")
    public String toLendList(){
        return "lendList";
    }

    @RequestMapping("/readerList")
    public String toReaderList(){
        return "readerList";
    }


}
