package com.gvssimux.pojo.webPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrUser {

    private String userid;

    //borrow
    private String borrowid;
    private String bookname;
    private String isbn;
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
}
