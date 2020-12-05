package com.gvssimux.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * userwant
 * @author 
 */
@Data
public class UserWant implements Serializable {
    private Integer id;

    /**
     * user表唯一标识
     */
    private String userid;

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
}