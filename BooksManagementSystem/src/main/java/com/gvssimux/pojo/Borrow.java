package com.gvssimux.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * borrow
 * @author 
 */
@Data
public class Borrow implements Serializable {
    private Integer id;

    private String userid;

    private String bookname;

    private String isbn;

    private String status;

    private static final long serialVersionUID = 1L;
}