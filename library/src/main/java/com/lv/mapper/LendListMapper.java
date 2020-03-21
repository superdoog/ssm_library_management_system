package com.lv.mapper;

import com.lv.pojo.LendList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lv
 */
public interface LendListMapper {

    /**
     * 根据reader_id查找借阅记录，分页
     * @param reader_id
     * @param currentPage
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<LendList> getLendList(@Param("reader_id") int reader_id, @Param("currentPage") int currentPage, @Param("pageSizeNo") int pageSize) throws Exception;

    /**
     * 根据ser_num查询记录
     * @param ser_num
     * @return
     * @throws Exception
     */
    public LendList getLendListBySer_num(@Param("ser_num") int ser_num) throws Exception;

    /**
     * 根据reader_id查询记录数量
     * @param reader_id
     * @return
     * @throws Exception
     */
    public int getCount(@Param("reader_id") int reader_id) throws Exception;

    /**
     * 删除记借阅录
     * @param ser_num
     * @return
     * @throws Exception
     */
    public int deleteBySer_num(@Param("ser_num") int ser_num) throws Exception;

    /**
     * 增加借阅记录
     * @param lendList
     * @return
     * @throws Exception
     */
    public int addLendList(@Param("lendList") LendList lendList) throws Exception;

}
