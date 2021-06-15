package com.gvssimux.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * user
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
     * 后台生成的唯一标识
     */
    private Integer id;

    /**
     * uuid
     */
    private String userid;

    /**
     * 用户昵称
     */
    private String uname;

    /**
     * 登录名
     */
    private String user;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 身份(用户、管理)
     */
    private String sign;

    /**
     * 剩余借书的次数
     */
    private Integer time;

    private static final long serialVersionUID = 1L;

    public User(Integer id, String userid) {
        this.id = id;
        this.userid = userid;
    }

    public User(String userid, String uname, String user, String pwd, String sign, Integer time) {
        this.userid = userid;
        this.uname = uname;
        this.user = user;
        this.pwd = pwd;
        this.sign = sign;
        this.time = time;
    }



}