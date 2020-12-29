package com.gvssimux.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * comment
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {
    private Integer id;

    /**
     * 此表的唯一标识
     */
    private String comid;

    /**
     * 用户昵称
     */
    private String uname;

    /**
     * user表唯一标识
     */
    private String uuid;

    /**
     * borrow表唯一标识
     */
    private String borrowid;

    /**
     * bookinf表唯一标识
     */
    private String isbn;

    /**
     * 评论内容
     */
    private String content;

    private static final long serialVersionUID = 1L;
}