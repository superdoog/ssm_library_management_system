package com.lv.service;

import com.lv.pojo.BookInfo;

import java.util.List;

/**
 * @author lv
 */
public interface BookService {

    public BookInfo getBookById(int book_id);

    public List<BookInfo> getBookList(String bookName,int currentPage, int pageSize);

    public int getCount(String bookName);

    public int addBook(BookInfo book);

    public int updateBook(BookInfo book);

    public int deleteBook(int book_id);

}
