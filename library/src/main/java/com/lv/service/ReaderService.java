package com.lv.service;

import com.lv.pojo.ReaderInfo;

import java.util.List;

/**
 * @author lv
 */
public interface ReaderService {

    public ReaderInfo getReaderById(int reader_id);

    public List<ReaderInfo> getReaderList(String username, int currentPage, int pageSize);

    public int getCount(String username);

    public int addReader(ReaderInfo reader);

    public int updateReader(ReaderInfo reader);

    public int deleteReader(int reader_id);

}
