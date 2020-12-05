package com.gvssimux.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * borrow
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrow implements Serializable {
    private Integer id;

    /**
     * 唯一标识，对应overtime
     */
    private String borrowid;

    /**
     * user表id
     */
    private String userid;

    /**
     * 书名
     */
    private String bookname;

    /**
     * ISBN唯一标识
     */
    private String isbn;

    /**
     * `待借出`，`超时`，`已借出`，`待归还`，`已归还`，`逾期`
     */
    private String status;

    /**
     * 提交申请时间
     */
    private Date starttime;

    /**
     * 取走时间
     */
    private Date starttime2;

    /**
     * 应归还时间
     */
    private Date endtime2;

    /**
     * 归还时间
     */
    private Date endtime;

    private static final long serialVersionUID = 1L;

    public Borrow(String borrowid, String userid, String bookname, String isbn, String status, Date starttime, Date starttime2, Date endtime2, Date endtime) {
        this.borrowid = borrowid;
        this.userid = userid;
        this.bookname = bookname;
        this.isbn = isbn;
        this.status = status;
        this.starttime = starttime;
        this.starttime2 = starttime2;
        this.endtime2 = endtime2;
        this.endtime = endtime;
    }
}