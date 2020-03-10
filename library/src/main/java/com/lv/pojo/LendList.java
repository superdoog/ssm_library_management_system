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
    private int serNum;

    /**
     * 图书号
     */
    private int bookId;

    /**
     * 读者号
     */
    private int readerId;

    /**
     * 借出日期
     */
    private Date lendDate;

    /**
     * 归还日期
     */
    private Date backDate;
}

