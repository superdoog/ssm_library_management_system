package com.lv.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lv
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInfo {
    /**
     * 书号
     */
    private int bookId;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 作者
     */
    private String author;

    /**
     * 总量
     */
    private int total;

    /**
     * 现量
     */
    private int number;
}

