package com.lv.service;

import com.lv.pojo.BookInfo;

import java.util.List;

/**
 * @author lv
 */
public interface BookService {

    public List<BookInfo> getBookList(String bookName,int currentPage, int pageSize);

    public int getCount() throws Exception;

}
