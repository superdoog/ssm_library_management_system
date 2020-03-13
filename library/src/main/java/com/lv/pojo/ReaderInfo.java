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
public class ReaderInfo {
    /**
     * 读者号
     */
    private int reader_id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;
}

