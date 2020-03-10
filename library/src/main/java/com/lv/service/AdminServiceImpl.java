package com.lv.service;

import com.lv.mapper.AdminMapper;
import com.lv.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    @Qualifier("adminMapper")
    private AdminMapper adminMapper;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public Admin login(String username) {
        Admin admin = null;
        try {
            admin = adminMapper.login(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }
}
