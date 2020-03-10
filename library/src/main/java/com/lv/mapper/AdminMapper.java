package com.lv.mapper;

import com.lv.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

    /**
     * 登录
     * @return
     * @throws Exception
     */
    public Admin login(@Param("username") String username) throws Exception;
}
