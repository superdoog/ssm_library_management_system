package com.lv.service;

import com.lv.pojo.LendList;

import java.util.List;

/**
 * @author lv
 */
public interface LendListService {

    public List<LendList> getLendList(int reader_id, int currentPage, int pageSize);

    public int getCount(int reader_id);

    public int deleteBySer_num(int ser_num);


}
