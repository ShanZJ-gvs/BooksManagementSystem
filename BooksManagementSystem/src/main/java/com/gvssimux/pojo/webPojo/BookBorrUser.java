package com.gvssimux.pojo.webPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrUser {

    private String userid;
    private String isbn;
    private String bookname;


    //borrow
    private String borrowid;
    private String status;
    private Date starttime;
    private Date starttime2;
    private Date endtime2;
    private Date endtime;

    //user
    private String uname;
    private String user;
    private String sign;
    private String time;

    //bookinf
    private String book_author;
    private String book_publish;
    private String book_type;
    private String bookintroduction;
    private String money;
    private String sum;
    private String num;

}
