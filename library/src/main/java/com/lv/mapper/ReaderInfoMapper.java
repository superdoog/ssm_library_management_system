package com.lv.mapper;

import com.lv.pojo.ReaderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lv
 */
public interface ReaderInfoMapper {

    /**
     * 根据ID查找reader
     * @param reader_id
     * @return
     * @throws Exception
     */
    public ReaderInfo getReaderById(@Param("reader_id") int reader_id) throws Exception;

    /**
     * 分页查找reader
     *
     * @param username
     * @param currentPage
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<ReaderInfo> getReaderList(@Param("username") String username, @Param("currentPage") int currentPage, @Param("pageSizeNo") int pageSize) throws Exception;

    /**
     * 根据username模糊查询数量 username可为空
     *
     * @param username
     * @return
     * @throws Exception
     */
    public int getCount(@Param("username") String username) throws Exception;

    /**
     * 增加读者
     * @param reader
     * @return
     * @throws Exception
     */
    public int addReader(ReaderInfo reader) throws Exception;

    /**
     * 修改读者
     * @param reader
     * @return
     * @throws Exception
     */
    public int updateReader(ReaderInfo reader) throws Exception;

    /**
     * 删除读者
     * @param reader_id
     * @return
     * @throws Exception
     */
    public int deleteReader(@Param("reader_id") int reader_id) throws Exception;

    /**
     * 登录
     * @return
     * @throws Exception
     */
    public ReaderInfo login(@Param("username") String username) throws Exception;
}
