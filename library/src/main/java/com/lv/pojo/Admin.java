package com.lv.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lv
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    /**
     *
     */
    private int adminId;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String username;

}

