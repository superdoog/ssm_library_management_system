package com.lv.service;

import com.lv.pojo.Admin;

public interface AdminService {
    /**
     * 登录
     * @return
     * @throws Exception
     */
    public Admin login(String username);
}
