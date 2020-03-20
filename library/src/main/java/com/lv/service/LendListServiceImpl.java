package com.lv.service;

import com.lv.mapper.LendListMapper;
import com.lv.pojo.LendList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lv
 */
@Service
public class LendListServiceImpl implements LendListService {

    @Autowired
    @Qualifier("lendListMapper")
    private LendListMapper lendListMapper;

    public void setLendListMapper(LendListMapper lendListMapper) {
        this.lendListMapper = lendListMapper;
    }

    @Override
    public List<LendList> getLendList(int reader_id, int currentPage, int pageSize) {
        List<LendList> lendList = null;
        //换算索引
        int currentPageNo = (currentPage - 1) * pageSize;
        try {
            lendList = lendListMapper.getLendList(reader_id, currentPageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lendList;
    }

    @Override
    public int getCount(int reader_id) {
        int count = 0;
        try {
            count = lendListMapper.getCount(reader_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int deleteBySer_num(int ser_num) {
        int flag = 0;
        try {
            flag = lendListMapper.deleteBySer_num(ser_num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
