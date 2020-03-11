package com.lv.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookInfoMapper {

    /**
     * 分页查找book
     * @param bookName
     * @param currentPage
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<com.lv.pojo.BookInfo> getBookList(@Param("bookName") String bookName, @Param("currentPage") int currentPage, @Param("pageSizeNo") int pageSize) throws Exception;

    public int getCount();
}
