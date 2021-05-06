package com.lengqi.user.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysRole implements Serializable {
    private Integer id;

    private String name;

    private String note;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}