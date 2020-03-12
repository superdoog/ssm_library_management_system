package com.lv.mapper;

import com.lv.pojo.BookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookInfoMapper {

    /**
     * 根据id查询书籍
     *
     * @param book_id
     * @return
     * @throws Exception
     */
    public BookInfo getBookById(@Param("book_id") int book_id) throws Exception;

    /**
     * 分页查找book
     *
     * @param bookName
     * @param currentPage
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<com.lv.pojo.BookInfo> getBookList(@Param("bookName") String bookName, @Param("currentPage") int currentPage, @Param("pageSizeNo") int pageSize) throws Exception;

    /**
     * 根据书名模糊查询数量 书名可为空
     *
     * @param bookName
     * @return
     * @throws Exception
     */
    public int getCount(@Param("bookName") String bookName) throws Exception;

    /**
     * 增加书籍
     *
     * @param book
     * @return
     * @throws Exception
     */
    public int addBook(BookInfo book) throws Exception;

    /**
     * 修改书籍
     * @param book
     * @return
     * @throws Exception
     */
    public int updateBook(BookInfo book) throws Exception;

    /**
     * 删除书籍
     * @param book_id
     * @return
     * @throws Exception
     */
    public int deleteBook(@Param("book_id") int book_id) throws Exception;
}
