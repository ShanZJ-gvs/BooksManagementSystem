package com.gvssimux.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * userwant
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWant implements Serializable {
    private Integer id;

    /**
     * 书名
     */
    private String bookname;

    /**
     * 作者
     */
    private String author;

    /**
     * 出版商
     */
    private String publish;

    /**
     * 备注
     */
    private String ps;

    /**
     * `待处理`，`已处理`，`拒绝`
     */
    private String status;

    private static final long serialVersionUID = 1L;

    public UserWant(String bookname, String author, String publish, String ps, String status) {
        this.bookname = bookname;
        this.author = author;
        this.publish = publish;
        this.ps = ps;
        this.status = status;
    }
}