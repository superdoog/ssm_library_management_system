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
    public int getCount() {
        int count = 0;
        count = bookInfoMapper.getCount();

        return count;
    }
}
