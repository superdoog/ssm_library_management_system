package com.lv.service;

import com.lv.mapper.ReaderInfoMapper;
import com.lv.pojo.ReaderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lv
 */
@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    @Qualifier("readerInfoMapper")
    private ReaderInfoMapper readerInfoMapper;

    public void setReaderInfoMapper(ReaderInfoMapper readerInfoMapper) {
        this.readerInfoMapper = readerInfoMapper;
    }

    @Override
    public ReaderInfo getReaderById(int reader_id) {
        ReaderInfo reader = null;
        try {
            reader = readerInfoMapper.getReaderById(reader_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reader;
    }

    @Override
    public List<ReaderInfo> getReaderList(String username, int currentPage, int pageSize) {
        List<ReaderInfo> readerInfoList = null;
        //换算索引
        int currentPageNo = (currentPage - 1) * pageSize;
        try {
            readerInfoList = readerInfoMapper.getReaderList(username, currentPageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readerInfoList;
    }

    @Override
    public int getCount(String username) {
        int count = 0;
        try {
            count = readerInfoMapper.getCount(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int addReader(ReaderInfo reader) {
        int flag = 0;
        try {
            flag = readerInfoMapper.addReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int updateReader(ReaderInfo reader) {
        int flag = 0;
        try {
            flag = readerInfoMapper.updateReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int deleteReader(int reader_id) {
        int flag = 0;
        try {
            flag = readerInfoMapper.deleteReader(reader_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
