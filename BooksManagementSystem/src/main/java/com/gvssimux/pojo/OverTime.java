package com.gvssimux.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * overtime
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OverTime implements Serializable {
    private Integer id;

    /**
     * 用户唯一标识符
     */
    private String userid;

    /**
     * borrow的唯一标识
     */
    private String borrow;

    /**
     * 想要更改的归还时间
     */
    private Date otime;

    private static final long serialVersionUID = 1L;

    public OverTime(String userid, String borrow, Date otime) {
        this.userid = userid;
        this.borrow = borrow;
        this.otime = otime;
    }
}