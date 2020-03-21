package com.lv.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lv
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LendList {
    /**
     * 流水号
     */
    private int ser_num;

    /**
     * 图书号
     */
    private int book_id;

    /**
     * 读者号
     */
    private int reader_id;

    /**
     * 借出日期
     */
    private Date lend_date;

    /**
     * 归还日期
     */
    private Date back_date;

    /**
     * 书名
     */
    private String book_name;

    public LendList(int book_id, int reader_id, Date lend_date, Date back_date) {
        this.book_id = book_id;
        this.reader_id = reader_id;
        this.lend_date = lend_date;
        this.back_date = back_date;
    }
}

