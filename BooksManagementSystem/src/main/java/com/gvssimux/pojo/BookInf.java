package com.gvssimux.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * bookinf
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInf implements Serializable {
    private Integer id;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 作者
     */
    private String bookAuthor;

    /**
     * 出版商
     */
    private String bookPublish;

    /**
     * 类型
     */
    private String bookType;

    /**
     * 介绍
     */
    private String bookIntroduction;

    /**
     * ISBN
     */
    private String isbn;

    /**
     * 定价
     */
    private String money;

    /**
     * 总量
     */
    private Integer sum;

    /**
     * 现有数量
     */
    private Integer num;

    private static final long serialVersionUID = 1L;

    public BookInf(String bookName, String bookAuthor, String bookPublish, String bookType, String bookIntroduction, String isbn, String money, Integer sum, Integer num) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublish = bookPublish;
        this.bookType = bookType;
        this.bookIntroduction = bookIntroduction;
        this.isbn = isbn;
        this.money = money;
        this.sum = sum;
        this.num = num;
    }

    public BookInf(Integer id, Integer num) {
        this.id = id;
        this.num = num;
    }
}