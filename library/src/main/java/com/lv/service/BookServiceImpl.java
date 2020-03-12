package com.lv.service;

import com.lv.mapper.BookInfoMapper;
import com.lv.pojo.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lv
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    @Qualifier("bookInfoMapper")
    private BookInfoMapper bookInfoMapper;

    public void setBookInfoMapper(BookInfoMapper bookInfoMapper) {
        this.bookInfoMapper = bookInfoMapper;
    }

    @Override
    public BookInfo getBookById(int book_id) {
        BookInfo book = null;
        try {
            book = bookInfoMapper.getBookById(book_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<BookInfo> getBookList(String bookName, int currentPage, int pageSize) {
        List<BookInfo> bookInfoList = null;
        //换算索引
        int currentPageNo = (currentPage - 1) * pageSize;
        try {
            bookInfoList = bookInfoMapper.getBookList(bookName, currentPageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookInfoList;
    }

    @Override
    public int getCount(String bookName) {
        int count = 0;
        try {
            count = bookInfoMapper.getCount(bookName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    @Override
    public int addBook(BookInfo book) {
        int flag = 0;
        try {
            flag = bookInfoMapper.addBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int updateBook(BookInfo book) {
        int flag = 0;
        try {
            flag = bookInfoMapper.updateBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int deleteBook(int book_id) {
        int flag = 0;
        try {
            flag = bookInfoMapper.deleteBook(book_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
